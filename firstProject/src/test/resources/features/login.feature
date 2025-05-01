Feature: Маска логина

  Scenario Outline: Логин в Mastodon
    Given пользователь находится на экране логина
    When пользователь выбирает сервер "<server>"
    Then поле для имени пользователя должно отображать "@<server>"

    Examples:
      | server  |
      | mas.to  |
      | c.im    |