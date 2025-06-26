Feature: Login en Siigo

  Scenario: Inicio de sesión exitoso con credenciales válidas
    Given que el usuario abre la aplicación de Siigo
    When ingresa sus credenciales válidas
    Then debería visualizar el panel principal de la aplicación