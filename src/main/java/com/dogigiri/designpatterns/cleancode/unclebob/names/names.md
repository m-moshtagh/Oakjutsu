## Names
Choosing a good name for functions, variables, classes and directories is much better than putting lots of time for documentation.
***
### Showing your intent:
The name should show your intention. for example:
`int d; // elapsed time in days`
This was considered good practice but this is much efficient:
`int elapsedTimeInDays`

### Describe the problem:
We should always choose names that communicate to us about what are they trying to solve so, we don't go through the
whole code to see exactly what they are serving.

### Avoid disinformation
Provide information with the name which is against the purpose we are going to serve.

### Pronounceable names
We should choose names that we can talk about them with others. unlike elon musk's child:)

### Avoid encodings
Do not use any notations for variables to see what type they are. for example ch for characters. We can easily understand that with IDE help.

### Proper names:
We need to choose noun names for variables, which hold Type instances. we need to avoid general names which doesn't provide any
useful information.
We choose verb names for functions. 
We choose adjectives for Enums.
We choose predicate names for boolean related variables or functions. like `isEmpty()`

> Depending on the scope of functions we can choose to use short and long abbreviation names. for example in long scope
> functions we can choose complete names because we don't want to look the whole scope to find out what it is. also 
> we can use short abbreviations in short scopes for example in a foreach we can use e instead of element.

> For public functions which are going to be called from different places we can use general purpose names like open.
> private methods should have longer explanatory names.

Derived classes have longer names, because they have adjectives in it.

