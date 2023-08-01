Feature: agregar producto de mayor valor al carrito y verificar para despues remover

	Como usuario quiero poder agregar un producto de mayor valor al carrito para despues remover el producto 
	

	Background:
		Given un usuario se encuentra en la pagina login
		When ingresa credenciales validas 
		
		
	@browser
	Scenario: Agregar producto de mayor valor al carrito
	    Given estoy en la página de inicio
	    When busco el producto de mayor valor
	    And hago clic en el botón de agregar al carrito
	    Then el logo carrito de la parte superior debera tener un numero 
			And verificar en la pagina cart si el producto se agrego correctamente
			When el usuario decide remover el producto del carrito
	    Then verificar si el producto se removio exitosamente 
	
