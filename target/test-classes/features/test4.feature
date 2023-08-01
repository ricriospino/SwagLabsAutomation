 Feature: Cerrar sesión (Logout)

	 como usuario quiero hacer logout estando dentro de mi cuenta para poder cerrar mi sesion

Background:
  Given el usuario debe estar logueado
  
@browser
Scenario: Hacer logout estando dentro de mi cuenta
  Given el usuario se encuentra dentro de su cuenta
  When el usuario hace clic en el botón Logout
  Then el usuario debería ser redirigido a la página de inicio de sesión


  