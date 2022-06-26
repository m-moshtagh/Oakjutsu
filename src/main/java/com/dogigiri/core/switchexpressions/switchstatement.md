# Switch Enhancement

This feature added to Java in version 13. We can now return expressions alongside statements in switch block and
store the result in a variable.

## Switch statements

To use this feature we use `->` instead of `:` in front of case keyword.
If we have multiple expressions for a case, we can use `yield` keyword in order to break the switch.

## Pattern matching

Instead of using `instanceof` keyword now we can use Wrapper classes on switch statements. We can also combine them with
other conditions.
