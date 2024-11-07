# Maintenance

### *Данный проект предназначен для ведения технического обслуживания (ТО) компьютерной и оргтехники техники.*


Приложение представляет собой REST API, выполненное в виде RESTful веб-сервисов предлагающих интерфейс для взаимодействия с базой данных.
Поддерживаются CRUD-операции: возможность создания, изменения, удаления, запрос данных по единицам компьютерной и оргтехники.
Органицация сущностей и связей между ними представлена на схеме 1.



![Схема 1](/images/emtity.png)

Схема 1. Сущности и связи базы данных "ТО компьютерной и оргтехники".



Разработка осуществлялась с использованием обобщенных классов как для сервисов, так и для контроллеров, что позволило более гибко осуществлять выполнении идентичных операция управления различными сущностями.
В коде использовались такие инструменты как Mapstruct, который в рамках данной работы не получил широкого применения, но предполагает использование в перспективе для построения запросов, собирающих данные из разных таблиц.

Кроме того, для упрощения манипуляций со встроенными типами данных, представляющий собой нумерованные списки, были написаны конверторы (TypeConvertor и StatusConvertor имплементирующие интерфейс AttributeConverter<Status, Integer> и реализующие методы convertToDatabaseColumn и convertToEntityAttribute этого интерфейса).

Также в данной работе был применен программный подход Criteria API используемый для создания типизированных запросов к базе данных с помощью интерфейса org.springframework.data.jpa.domain.Specification. Это сделало возможным использование гибкой фильтрации данных по многим критериям, содержащим поля различных таблиц. Для использования этих возможностей были расширены репозитории MaintenanceRepository и EquipmentRepository следующим интерфейсом: org.springframework.data.jpa.repository.JpaSpecificationExecutor<T>. 

Пример использования данного вида фильтрации приведен на рис. 1.



![Рисунок 1](/images/criteria.png)

Рисунок 1. Фильтрация данных в таблице "equipment" (endpoint: "/equipments/search", параметры запроса передаются в теле метода)





