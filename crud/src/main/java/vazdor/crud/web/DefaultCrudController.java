package vazdor.crud.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vazdor.crud.DFormManager;
import vazdor.crud.list.CrudList;

@Controller
@RequestMapping("/crud")
public class DefaultCrudController {
	
	private static final Logger logger = Logger.getLogger(DefaultCrudController.class);
	
	@Autowired
	private DFormManager dformManager;
	
	@RequestMapping(value="/list/{idCrud}/{offset}/{max}", method=RequestMethod.GET)
	public String listPage(@PathVariable String idCrud, @PathVariable Integer offset, @PathVariable Integer max, Model model) {
		CrudList crudList = dformManager.list(idCrud, offset, max);
		model.addAttribute("crudList", crudList);
		return "crud/list";
	}
	
	@RequestMapping(value="/new/{idCrud}", method=RequestMethod.GET)
	public String blankForm(@PathVariable String idCrud, Model model) {
		String dform = dformManager.blankForm(idCrud, "/crud/create/"+idCrud, "post");
		model.addAttribute("dform", dform);
		return "crud/new";
	}
	
	@RequestMapping(value="/create/{idCrud}",
            method=RequestMethod.POST,
            consumes="application/json",
            produces="application/json")
	@ResponseBody
	public CrudResponse create(@PathVariable String idCrud, @RequestBody String jsonForm) {
		logger.debug("Salvando " + idCrud + ". Dados: " + jsonForm);
		dformManager.create(idCrud, jsonForm);
		return CrudResponse.ok();
	}
	
	@RequestMapping(value="/update/{idCrud}/{pk}",
            method=RequestMethod.POST,
            consumes="application/json",
            produces="application/json")
	@ResponseBody
	public CrudResponse update(@PathVariable String idCrud, @PathVariable Long pk, @RequestBody String jsonForm) {
		logger.debug("Alterando " + idCrud + ". Dados: " + jsonForm);
		dformManager.update(idCrud, jsonForm, pk);
		return CrudResponse.ok();
	}
	
	@RequestMapping(value="/delete/{idCrud}/{pk}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable String idCrud, @PathVariable Long pk) {
		logger.debug("Deletando " + idCrud + ". ID: " + pk);
		dformManager.delete(idCrud, pk);
		return new ModelAndView("redirect:/crud/list/"+idCrud+"/0/0");
	}
	
	@RequestMapping(value="/load/{idCrud}/{pk}", method=RequestMethod.GET)
	public String load(@PathVariable String idCrud, @PathVariable Long pk, Model model) {
		String dform = dformManager.load(idCrud, pk, "/crud/update/"+idCrud+"/"+pk, "post");
		model.addAttribute("dform", dform);
		return "crud/new";
	}
}