%{
	#include<stdio.h>
	#include<stdlib.h>

	void yyerror(const char *str){
		fprintf(stderr, "Error: %s\n", str);
	}

	int yywrap(){
		return 1;
	}

	main(){
		yyparse();
	}
%}

%token DELETE FROM ID WHERE AND;

%% 

line: delete items using condition '\n' {printf("Input Accepted\n"); };

delete: DELETE;

items: '*' | id;

id: ID | ID ',' id;

using: FROM ID WHERE;

condition: ID '=' ID | ID '=' ID AND condition;

%%