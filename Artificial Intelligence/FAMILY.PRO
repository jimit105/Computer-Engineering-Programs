Domains
	name=symbol
	
Predicates
	male(name)
	female(name)
	child(name, name)
	husband(name, name)
	wife(name,name)
	mother(name, name)
	father(name, name)
	sibling(name, name)
	sister(name, name)
	brother(name, name)
	grandfather(name,name)
	grandmother(name,name)
	grandchild(name, name)
	grandson(name, name)
	granddaughter(name, name)
	uncle(name,name)
	aunt(name,name)
	cousin(name,name)
	

Clauses
	male(rickard).
	male(eddard).
	male(benjen).
	male(robb).
	male(bran).
	male(rickon).
	male(jon).

	female(lyarra).
	female(lyanna).
	female(catelyn).
	female(sansa).
	female(arya).
	
	child(eddard, rickard).
	child(lyanna, rickard).
	child(benjen, rickard).
	child(robb, eddard).
	child(sansa, eddard).
	child(arya, eddard).
	child(bran, eddard).
	child(rickon, eddard).
	child(jon,lyanna).	

	husband(rickard, lyarra).
	husband(eddard, catelyn).


	wife(Wname, Hname):- husband(Hname, Wname).
	mother(Mname, Cname):- child(Cname,Fname), wife(Mname,Fname), female(Mname).  
	father(Fname, Cname):-child(Cname, Fname), male(Fname).
	sibling(X,Y):- father(Fname, X), father(Fname, Y).
	sister(Sname,SibName):-sibling(Sname,SibName),female(Sname),Sname<>SibName.
	brother(Bname, SibName):-sibling(Bname, Sibname), male(Bname),Bname<>SibName.
	grandmother(GMname,GCname):-father(Fname, GCname), mother(GMname, Fname).
	grandfather(GFname, GCname):- father(Fname, GCname), father(GFname, Fname).
	grandchild(GCname,GPname):-grandfather(GPname,GCname);grandmother(GPname, GCname).
	grandson(GCname, GPname):- grandchild(GCname, GPname), male(GCname).
	granddaughter(GCname, GPname):- grandchild(GCname, GPname), female(GCname).
	uncle(Uname,Cname):-child(Cname,Pname),sibling(Pname,Uname),male(Uname),Pname<>Uname.
	aunt(Aname,Cname):-child(Cname,Pname),sibling(Pname,Aname),female(Aname),Pname<>Aname.
	cousin(Cname, X):- uncle(Uname, X), child(Cname, Uname).