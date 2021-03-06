# Содержание

1. [Use Case Diagram](#1) <br>
	1.1. [Actors](#1.1) <br> 
	1.2. [Use Cases](#1.2) <br>
  1.2.1. [Добавить расходы](#1.2.1) <br>
  1.2.2. [Показать расходы](#1.2.2) <br>
  1.2.3. [Изменить язык](#1.2.3) <br>
  1.2.4. [Изменить цвет оформления](#1.2.4) <br>
  1.2.5 [Добавить доходы](#1.2.5) <br>
  1.2.6 [Показать доходы](#1.2.6) <br>
2. [Activity Diagram](#2) <br>
3. [Secuance Diagram](#3) <br>
4. [Class Diagram](#4) <br>
5. [State Diagram](#5) <br>
6. [Component Diagram](#6) <br>

# 1. Use Case Diagram <a name = "1"></a>

## 1.1 Actors <a name = "1.1"></a>
  
  Actor | Desription
:-----|:----------
Пользователь  | объект пользующийся приложением

## 1.2 Use Cases <a name = "1.2"></a>
<img src="https://raw.githubusercontent.com/SlavkaGoldfinch/MoneyHelper/master/Documents/UseCase%20Diagram/Actors.jpg">

### 1.2.1 Добавить расходы <a name = "1.2.1"></a>

**Description**: Пользователь нажимает кнопку "-", после чего ему становится доступно добавление расходов. 
Поток событий:

1. При нажатие на кнопку "-", открывается окно добавления расходов ;

2. Пользователь выбирает валюту;

2. Пользователь вводит расходы;

3. Приложение конвертирует в стандартную валюту.

4. Пользователь выбирает раздел;

5. Добавление в список;

6. Конец.



### 1.2.2 Показать расходы <a name = "1.2.2"></a>

**Description**: Пользователь нажимает кнопку просмотра расходов,  после чего открывается список расходов.
Поток событий:

1. Нажатие на кнопку раздела;

2.  Открытие списка расходов раздела;

3. Конец.



### 1.2.3 Изменить язык <a name = "1.2.3"></a>

**Description**: Пользователь нажимает кнопку настроек,  после чего открывается окно настроек с доступом к изменению языка.
Поток событий:

1. Нажатие на кнопку настроек;

2. Открытие окна настроек;

3. Нажатие кнопки выбора языка;

4. Выбор языка;

5. Конец.

### 1.2.4 Изменить цвет оформления <a name = "1.2.4"></a>

**Description**: Пользователь нажимает кнопку настроек,  после чего открывается окно настроек с доступом к изменению цвета оформления.
Поток событий:

1. Нажатие на кнопку настроек;

2. Открытие окна настроек;

3. Нажатие кнопки выбора цвета оформления;

4. Выбор цвета оформления;

5. Конец.


### 1.2.5 Добавить доходы <a name = "1.2.5"></a>

**Description**: Пользователь нажимает кнопку "+", после чего ему становится доступно добавление расходов. 
Flow of events:

1. При нажатие на кнопку "+", открывается окно добавления доходов;

2. Пользователь выбирает валюту;

2. Пользователь вводит доходы;

3. Приложение конвертирует в стандартную валюту.

4. Пользователь выбирает раздел;

5. Добавление в список;

6. Конец.

### 1.2.6 Показать доходы <a name = "1.2.6"></a>

**Description**: Пользователь нажимает кнопку просмотра доходов,  после чего открывается список доходов.
Поток событий:

1. Нажатие на кнопку раздела;

2. Открытие списка доходов раздела;

3. Конец.



# 2. Activity Diagram <a name = "2"></a>
Activity diagram is [here](https://github.com/SlavkaGoldfinch/MoneyHelper/tree/master/Documents/Activity%20Diagram)


# 3. Sequence Diagram <a name = "3"></a>
<img src="https://raw.githubusercontent.com/SlavkaGoldfinch/MoneyHelper/master/Documents/Sequence%20Diagram/Sequence%20Diagram.png">


# 4. Class Diagram <a name = "4"></a>
<img src="https://raw.githubusercontent.com/SlavkaGoldfinch/MoneyHelper/master/Documents/ClassDiagram.png">


# 5. State Diagram <a name = "5"></a>
<img src="https://raw.githubusercontent.com/SlavkaGoldfinch/MoneyHelper/master/Documents/SostDiagram.png">


# 6. Component Diagram <a name = "6"></a>
<img src="https://raw.githubusercontent.com/SlavkaGoldfinch/MoneyHelper/master/Documents/StructDiagram.png">
