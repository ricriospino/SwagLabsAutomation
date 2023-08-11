 
Feature: Realizar una compra exitosa 

	Como usuario quiero poder registrarme y agregar un producto para posteriormente poder comprarlo

Background:
  Given el usuario está logueado
    And el usuario ha agregado al menos un item al carrito
@browser 
Scenario Outline: Comprar productos
  Given el usuario se encuentra en la página de checkout Your Information
  When el usuario completa todos los campos solicitados de información del cliente
    And hace clic en el botón <botonCheckout1>
  Then el usuario debería ser redirigido a la página de Checkout Overview


  Given el usuario está en la página de Checkout Overview
  When el usuario verifica los productos comprados y el total de la compra incluyendo Tax
  And hace clic en el boton <botonCheckout2>
  Then la compra se realiza satisfactoriamente
  And el usuario debería ver un mensaje de confirmación de la compra
  
  @data
		Examples:
				|botonCheckout1 |botonCheckout2  |
				|"Continue" 		| "Finish" 			 |

  