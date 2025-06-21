Feature: Crear cliente en Siigo

  Scenario: Crear un cliente persona natural exitosamente
    Given que el usuario abre la aplicación de Siigo
    And ingresa sus credenciales válidas
    And ingresa al modulo de Crear Clientes
    When diligencia todos los campos obligatorios con datos válidos
    And confirma la creación del cliente
    Then debería ver el mensaje "Tercero guardado exitosamente"
