%{
#include <stdio.h>

void yyerror (const char *str) {
	fprintf(stderr, "error: %s\n", str);
}

int yywrap() {
	return 1;
}

main() {
	yyparse();
}

%}

%%

%token DELETE FROM IDENTIFIER WHERE AND;

line: delete items using condition '\n' { printf("Syntax Correct\n"); };

delete: delete;

items: '*' | identifiers;

identifiers: IDENTIFIER | IDENTIFIER ',' identifiers;
	
using: FROM IDENTIFIER WHERE;

condition: IDENTIFIER '=' IDENTIFIER | IDENTIFIER '=' IDENTIFIER AND condition;

%%