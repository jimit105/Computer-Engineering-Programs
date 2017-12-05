%{
#include <stdlib.h>
#include <stdio.h>
int yylex(void);
#include "y.tab.h"
%}

%token DELETE FROM IDENTIFIER WHERE AND;
%%
line: delete items using condition '\n' { printf("Syntax Correct\n"); };

delete: DELETE;

items: '*' | identifiers;

identifiers: IDENTIFIER | IDENTIFIER ',' identifiers;
	
using: FROM IDENTIFIER WHERE;

condition: IDENTIFIER '=' IDENTIFIER | IDENTIFIER '=' IDENTIFIER AND condition;
%%
void yyerror(char *s)
{
fprintf(stderr,"%s\n",s);
return;
}

int main(void)
{
/*yydebug=1;*/
yyparse();
return 0;}
yywrap()
{
  return(1);
}
