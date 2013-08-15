Vazdor
======

Estrutura de componentes para uso nos sistemas.

## Locale ##
Componente para internacionalização. Para utilizar como componente deve-se copiar este código no app-context da aplicação:

    <bean id="messageSource"
		class="org.springframework.context.support.ReloadableResourceBundleMessageSource">
		<property name="basename" value="classpath:locale/messages" />
	</bean>

	<bean id="vazdorLocale" class="vazdor.locale.impl.VazdorLocaleImpl">
		<property name="localesSuportados">
			<list>
				<value>pt_BR</value>
				<value>en_US</value>			
			</list>
		</property>
		<property name="localesNomeAmigavel">
			<list>
				<value>Português Brasil(pt_BR)</value>
				<value>Inglês EUA(en_US)</value>
			</list>
		</property>
		<property name="localeSelecionado" value="pt_BR"/>
	</bean>
	
	<bean id="vazdorMessage" class="vazdor.locale.impl.VazdorMessageImpl">
		<property name="messageSource" ref="messageSource" />
		<property name="vazdorLocale" ref="vazdorLocale" />
	</bean>
