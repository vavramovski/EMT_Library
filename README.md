# Библиотека

Во овој проект се следи Domain Driven Design и се обработува еден ограничен контекст (bounded context) од библиотека која врши позајмици на книги. Се чуваат информации за книгите, заедно со нивните примероци, корисниците на библиотеката и направените позајмици.
Агрегатите во овој ограничен контекст се:
  - book_catalog
  - users
  - order_management

Исто така, искористени се неколку вредносни објекти (value objects).

Настаните (events) кои се случуваат во ова сценарио се:
  - креирање на позајмица (еден корисник позајмува одреден примерок од одредена книга)
  - завршување на позајмица (корисникот го враќа позајмениот примерок)
  
За контрола на овие евенти користиме Apache Kafka.

Кога се креира нова позајмица, состојбата (state) на примерокот кој се позајмува се менува во OCCUPIED, додека кога се завршува позајмица, состојбата на соодветниот примерок се поставува на FREE.
