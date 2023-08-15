Feature: Realizar una compra exitosa con data usuario de Base de datos Mysql
	
	Descripción: 
	<div>
		<p>
			<strong>Realizar una compra exitosa con data usuario de Base de datos Mysql</strong>:  Como usuario quiero poder 
			registrarme y agregar un producto para posteriormente poder comprarlo
		</p>
		<p>
			<strong>Resultado esperado</strong>: Realizo la compra satisfactoriamente
		</p>
		<p>
			<strong>Tipo de característica</strong>: Data Mysql
		</p>
		<p>
			<strong>Comentarios</strong>: La prueba cubre operaciones de base de datos de manera exitosa
		</p>
	</div>
	
 

Background:

    Given el usuario BD está logueado
    And el usuario BD ha agregado al menos un item al carrito

@browser 
Scenario: Comprar productos con datos de usuario de una BD
  Given el usuario BD se encuentra en la página de checkout Your Information
  When el usuario BD completa todos los campos solicitados de información del cliente
  And realiza una consulta a la base de datos a traves de una query para obtener el usuario con id "1" para enviar datos del usuario
  And hace click en el botón Continue 
  Then el usuario BD debería ser redirigido a la página de Checkout Overview

  Given el usuario BD está en la página de Checkout Overview
  When el usuario BD verifica los productos comprados y el total de la compra incluyendo Tax
  And hace click en el botón Finish
  Then la compra se realiza de manera correcta
  And el usuario BD debería ver un mensaje de confirmación de la compra
 
 