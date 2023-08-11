Feature: Realizar una compra exitosa con data usuario de API

  Como usuario quiero poder registrarme y agregar un producto para posteriormente poder comprarlo

Background:

    Given el usuario API está logueado
    And el usuario API ha agregado al menos un item al carrito

@browser 
Scenario: Comprar productos con datos de usuario de una api
  Given el usuario API se encuentra en la página de checkout Your Information
  When el usuario API completa todos los campos solicitados de información del cliente
  And realiza un request a través del endpoint con id "1" para obtener datos del usuario API 
  And hace clic en el botón Continue 
  Then el usuario API debería ser redirigido a la página de Checkout Overview

  Given el usuario API está en la página de Checkout Overview
  When el usuario API verifica los productos comprados y el total de la compra incluyendo Tax
  And hace clic en el botón Finish
  Then la compra se realiza Exitosamente
  And el usuario API debería ver un mensaje de confirmación de la compra
 
 