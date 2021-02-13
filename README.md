# spring-data
Spring Data's mission is to provide a familiar and consistent, Spring-based programming model for data access while still retaining the special traits of the underlying data store. 
It makes it easy to use data access technologies, relational and non-relational databases, map-reduce frameworks, and cloud-based data services. This is an umbrella project which contains many subprojects that are specific to a given database. The projects are developed by working together with many of the companies and developers that are behind these exicting technologies.

Feature: 
- Powerful repository and custom object-mapping abstractions.
- Dynamic query derivation from repository method names.
- Implementation domain base classes providing basic properties.
- Support for transparent auditing (created, last changed).
- Posibility to integrate custom repository code.
- Easy Spring integration via JavaConfig and custom XML namespaces.
- Advanced integration with Spring MVC controllers.
- Experimental support for cross-store persistence.

Practice: Spring Data JPA - H2 In memory database
   Things to implement:  
   
    - CRUD
       Retrieve, persist, modify, remove entities.
       Hibernate use save method for both persist and modify. If the entity has primary key value then it will check if this value exists or not. If not, it will insert.                Otherwise, it will update record.
    - Derived query: String operators, relational operators, logical operators, date comparison (before, after, between), ordering results (order by), limiting query results (top, first),transversing nested properties (many to one, one to one,...)
    
    - Additional query techniques
        @Query
        @NamedQuery
        Paging result (PagingAndSortingRepo, Pagable)
        Sorting result
        Query method return types: Collection, List, Iterable, Slice, Page,...
        
    - Advanced JPA Techniques
        Customizing Repository
        Global Repository Customization
        Async Queries
        Auditing
        Modifying Queries (@MOdifying, @Query)
