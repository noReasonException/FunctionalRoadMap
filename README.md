| Functional Programming RoadMap                                                          |                                                               |
|-----------------------------------------------------------------------------------------|---------------------------------------------------------------|
| Skills                                                                                  |                                                               |
| Level 1                                                                                 |                                                               |
| **Immutable data**                                                                      | lvl1.skills.ImmutableData.scala                               |
| **Second-order functions**                                                              | lvl1.skills.SecondOrderFunctions.scala                        |
| **Constructing and destructuring**                                                      | lvl1.skills.ConstructingAndDestructing.scala                  |
| **Function composition**                                                                | lvl1.skills.FunctionComposition.scala                         |
| **First-class functions and lambdas**                                                   | Excluded(If you understand Second order)                      |
|                                                                                         |                                                               |
| Test Level 1                                                                            |                                                               |
| Use second-order functions (map, filter, fold) on immutable data structures             | lvl1.test.SecondOrderFunctionUsage                            |
| Destructure values to access their components(Destructror Pattern)                      | lvl1.skills.ConstructingAndDestructing.scala                  |
| Use data types to represent optionality                                                 | lvl1.test.Optionality                                         |
| Read basic type signatures                                                              | Look the signatures at lvl1.skills.SecondOrderFunctions.scala |
| Pass lambdas to second-order functions                                                  | Look the lambdas at lvl1.skills.FunctionComposition           |
|                                                                                         |                                                               |
| Level 2                                                                                 |                                                               |
| Algebraic data types                                                                    | lvl2.skills.adtvsoop.AdtVsOop                                 |
| Pattern matching                                                                        | Look at lvl1.skills.ConstructingAndDestructing.scala          |                                            |   |
| Parametric polymorphism                                                                 | lvl2.skills.ParametricPolymorphism                            |
| General recursion                                                                       | lvl2.skills.GeneralRecursion                                  |
| Type classes, instances, and laws                                                       | lvl2.skills.TypeClasses                                       |
| Lower-order abstractions (equal, semigroup, monoid, and so on)                          | lvl2.skills.lowerOrderAbstractions                            |
| Referential transparency and totality                                                   |                                                               |
| Higher-order functions                                                                  |                                                               |
| Partial application, currying, and point-free style                                     |                                                               |
|                                                                                         |                                                               |
| Test Level 2                                                                            |                                                               |
| Solve problems without nulls, exceptions, or type casts                                 |                                                               |
| Process and transform recursive data structures using recursion                         |                                                               |
| Able to use functional programming in the small                                         |                                                               |
| Write basic monadic code for a concrete monad                                           |                                                               |
| Create type class instances for custom data types                                       |                                                               |
| Model a business domain with abstract data types (ADTs)                                 |                                                               |
| Write functions that take and return functions                                          |                                                               |
| Reliably identify and isolate pure code from an impure code                             |                                                               |
| Avoid introducing unnecessary lambdas and named parameters                              |                                                               |
|                                                                                         |                                                               |
| Level 3                                                                                 |                                                               |
| Generalized algebraic data type                                                         |                                                               |
| Higher-kinded types                                                                     |                                                               |
| Rank-N types                                                                            |                                                               |
| Folds and unfolds                                                                       |                                                               |
| Higher-order abstractions (category, functor,Applicative, monad)                        | lvl3.higherOrderAbstractions                                  |
| Basic optics                                                                            |                                                               |
| Implement efficient persistent data structures                                          |                                                               |
| Existential types                                                                       |                                                               |
| Embedded DSLs using combinators                                                         |                                                               |
|                                                                                         |                                                               |
| Test Level 3                                                                            |                                                               |
| Able to implement large functional programming applications                             |                                                               |
| Test code using generators and properties                                               |                                                               |
| Write imperative code in a purely functional way through monads                         |                                                               |
| Use popular purely functional libraries to solve business problems                      |                                                               |
| Separate decision from effects                                                          |                                                               |
| Write a simple custom lawful monad                                                      |                                                               |
| Write production medium-sized projects                                                  |                                                               |
| Use lenses and prisms to manipulate data                                                |                                                               |
|                                                                                         |                                                               |
| Level 4                                                                                 |                                                               |
| Codata                                                                                  |                                                               |
| (Co)recursion schemes                                                                   |                                                               |
| Advanced optics                                                                         |                                                               |
| Dual abstractions (comonad)                                                             |                                                               |
| Monad transformers                                                                      |                                                               |
| Free monads and extensible effects                                                      |                                                               |
| Functional architecture                                                                 |                                                               |
| Advanced functors (exponential, profunctors, contravariant)                             |                                                               |
| Embedded domain-specific languages (DSLs) using generalized algebraic datatypes (GADTs) |                                                               |
| Advanced monads (continuation, logic)                                                   |                                                               |
| Type families, functional dependencies (FDs)                                            |                                                               |
|                                                                                         |                                                               |
| Test Level 4                                                                            |                                                               |
| Design a minimally powerful monad transformer stack                                     |                                                               |
| Write concurrent and streaming programs                                                 |                                                               |
| Use purely functional mocking in tests.                                                 |                                                               |
| Use type classes to modularly model different effects                                   |                                                               |
| Recognize type patterns and abstract over them                                          |                                                               |
|                                                                                         |                                                               |
| Generic programming                                                                     |                                                               |
| Type-level programming                                                                  |                                                               |
| Dependent-types, singleton types                                                        |                                                               |
| Category theory                                                                         |                                                               |
| Graph reduction                                                                         |                                                               |
| Higher-order abstract syntax                                                            |                                                               |
| Compiler design for functional languages                                                |                                                               |
| Profunctor optics                                                                       |                                                               |
|                                                                                         |                                                               |
| Test Level 5                                                                            |                                                               |
| Design a generic, lawful library with broad appeal                                      |                                                               |
| Prove properties manually using equational reasoning                                    |                                                               |
| Design and implement a new functional programming language                              |                                                               |
| Create novel abstractions with laws                                                     |                                                               |
| Write distributed systems with certain guarantees                                       |                                                               |
| Use proof systems to formally prove properties of code                                  |                                                               |
| Create libraries that do not permit invalid states.                                     |                                                               |
| Use dependent typing to prove more properties at compile time                           |                                                               |
| Understand deep relationships between different concepts                                |                                                               |
| Profile, debug, and optimize purely functional code with minimal sacrifices             |                                                               |
