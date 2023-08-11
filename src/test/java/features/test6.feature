Feature: Resetear App de compra

como usuario deseo realizar un reset a mi App de compra para comenzar de nuevo

Background:
  Given el usuario esta logueado
  And el usuario ha seleccionado al menos un producto en el carrito

@browser
Scenario: Usuario realiza un reset de la App de compra
  When el usuario realiza un reset de la App de compra
  Then el carrito de compra debería estar vacío
  
  
  
  
  