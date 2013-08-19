package vazdor.crud.web;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vazdor.crud.DFormManager;
import vazdor.crud.list.CrudList;

@Controller
@RequestMapping("/crud")
public class DefaultCrudController {
	
	@Autowired
	private DFormManager dformManager;
	
	@RequestMapping(value="/list/{idCrud}/{offset}/{max}", method=RequestMethod.GET)
	public String listPage(@PathVariable String idCrud, @PathVariable Integer offset, @PathVariable Integer max, Model model) {
		CrudList crudList = dformManager.list(idCrud, offset, max);
		model.addAttribute("crudList", crudList);
		return "list";
	}
	
	@RequestMapping(value="/new/{idCrud}", method=RequestMethod.GET)
	public String blankForm(@PathVariable String idCrud, Model model) {
		String dform = dformManager.blankForm(idCrud, "", "post");
		model.addAttribute("dform", dform);
		return "new";
	}
	
	@RequestMapping(value="/create/{idCrud}",
            method=RequestMethod.POST,
            consumes="application/json",
            produces="application/json")
	public String create(@PathVariable String idCrud, @RequestBody String jsonForm) {
		dformManager.create(idCrud, jsonForm);
		return "list";
	}
	
	@RequestMapping(value="/update/{idCrud}/{pk}",
            method=RequestMethod.POST,
            consumes="application/json",
            produces="application/json")
	public String update(@PathVariable String idCrud, @RequestBody String jsonForm, @PathVariable Serializable pk) {
		dformManager.update(idCrud, jsonForm, pk);
		return "list";
	}
	
	@RequestMapping(value="/delete/{idCrud}/{pk}", method=RequestMethod.POST)
	public String delete(@PathVariable String idCrud, @PathVariable Serializable pk) {
		dformManager.delete(idCrud, pk);
		return "list";
	}
	
	@RequestMapping(value="/delete/{idCrud}/{pk}", method=RequestMethod.POST)
	public String load(@PathVariable String idCrud, @PathVariable Serializable pk, Model model) {
		String dform = dformManager.load(idCrud, pk, "", "post");
		model.addAttribute("dform", dform);
		return "edit";
	}
}
