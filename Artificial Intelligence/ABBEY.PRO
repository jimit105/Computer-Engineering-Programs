Domains
	name, sex, occupation,reason,object,proof = symbol

Predicates
	person_details(name, sex, occupation)
	murdered(name)
	murdered_with(name, object)
	motive(reason)
	owns(name, object)
	owns_probably(name, object)
	operates_identically(object, object)
	killer(name)
	suspect(name)
	loved(name, name)
	abused(name, name)
	/* abused(abused, abused_by) */
	evidence(proof)
	statement(name, proof)
	lied(name)
	motive_of(name, reason)


Clauses
	person_details(teresa, f, maid).
	person_details(croker, m, captain).
	person_details(eustace, m , business).
	person_details(randall_gang,m,theft).
	person_details(mary,f,housewife).

	murdered(eustace).
	murdered_with(eustace, poker).

	evidence(murder).
	statement(mary, theft).
	statement(teresa, theft).
	lied(X):- evidence(A), statement(X,B), A<>B.

	loved(croker, mary).

	abused(mary, eustace).

	motive(money).
	motive(jealousy). 
	motive(get_rid_of).
	
	motive_of(Person, Motive):-person_details(Person, _, theft), motive(Motive), Motive=money.
	motive_of(Person, Motive):-person_details(Person, _, _), motive(Motive), Motive=get_rid_of, abused(Person, eustace).
	motive_of(Person, murder):-person_details(Person, _, _), motive(Motive), Motive=jealousy, loved(Person, mary).
	
	owns(eustace, poker).	
	operates_identically(poker,knife).	
	owns_probably(teresa, knife).
	owns_probably(randall_gang, knife).
	owns_probably(croker, knife).
	owns_probably(Person, Object):-owns(Person,Object),operates_identically(poker, Object).
		
	suspect(X):-motive(money), person_details(X,_,theft);person_details(X,_,maid).
	suspect(X):-motive(jealousy), person_details(X,_,_), person_details(Y,_,_),loved(X,Y).
	suspect(X):-motive(get_rid_of), abused(X,Y), murdered(Y).

	killer(Killer):-
	person_details(Killer,_,_), murdered(Killed), Killed<>Killer, suspect(Killer), murdered_with(Killed, Weapon), owns_probably(Killer, Object), operates_identically(Weapon, Object), evidence(Evidence), motive_of(Killer, Motive), Evidence=Motive.
