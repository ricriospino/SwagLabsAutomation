Feature: Validar cookies y carga de datos de cuenta
  
como usuario quiero validar la sesión de mi cuenta para validar si se esta dando correctamnete

Background:

   Given que el usuario está logeado
   And ha seleccionado anteriormente un producto desde la página de inicio
   
@browser
Scenario: Validar que los datos de la cuenta se cargan correctamente a traves de cookies
   When el usuario inicia sesión por segunda vez
   Then todos sus datos de cuenta deben estar cargados correctamente
  
  