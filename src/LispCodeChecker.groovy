/**
 * This function will return true if all parentheses of the string parameter are closed and nested.
 *
 * @param code this is the code string that will be validated
 * @return boolean true only if the code is properly closed and nested
 */

def validateParentheses(String code){

    openParenCount = 0
    for(int i = 0; i < code.length(); i++){
        // For each character we will add to the count when there is an open parentheses
        // and subtract when there is a close parentheses
        if(code[i] == '(')
            openParenCount++
        if(code[i] == ')')
            openParenCount--
        // The following test will catch when a parentheses is not properly closed
        if(openParenCount < 0)
            return false
    }
    // If we have reached the end of the file our count should be zero to indicate matching pairs of parentheses
    return (openParenCount == 0)
}

/**
 * Main script section for testing
 */

// Initialize our tests array
def tests = []

// Populate tests array
// these do not have actual code in them as every character that is not a parentheses is ignored in the function

tests[0] = "(((()))((()())()))"    // true
tests[1] = "(())"                  // true
tests[2] = "())("                  // false
tests[3] = "())(()"                // false
tests[4] = "()(())"                // true

// Run tests against the function and print out the results
tests.each { test ->
    println validateParentheses(test)
}

// Here is a brief full code example of a lisp program
def full_code = """
(let ((in (open "test_file.txt" :if-does-not-exist nil)))
   (when in
      (loop for line = (read-line in nil)
      
      while line do (format t "~a~%" line))
      (close in)
   )
)
"""

// Running the test against the full code example
println validateParentheses(full_code)