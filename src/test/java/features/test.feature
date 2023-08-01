Feature: Login
	Como usuario quiero poder logearme para poder ingresar a la pagina con mi cuenta.
	
	@browser
	Scenario Outline: Ingresar a la pagina Home para poder loguerme  (Happy path )
	
		Given El usuario se encuentra en la Pagina login
		When ingresa su nombre de <usuario> y <contrasena> válidos
    And hace clic en el botón login
    Then debería ser redirigido a la página de Home Swag Labs
	
		@data
		Examples:
				|usuario 				 |contrasena  |
				|"standard_user" | "secret_sauce" |



