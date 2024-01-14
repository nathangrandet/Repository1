import math

#Importer le module datetime, avec l'alias dt
import datetime as dt 
import locale
locale.setlocale(locale.LC_ALL,'')

# Commentaire

# Cette variable contient un entier
quantite = 30
# Cette variable contient un float
prix_unitaire = 49.99
# Cette variable contient le résultat de la multiplication de la quantité par le prix unitaire
sous_total = prix_unitaire * quantite

# Affiche le résultat
print(sous_total)
print(f"Sous-total : {sous_total:,.2f} $")

taux_de_TVA = 0.055
print(f"Taux de TVA {taux_de_TVA:.2%}")
exemple_1 = f'Taux de TVA {taux_de_TVA:.2%}'
exemple_2 = f"Taux de TVA {taux_de_TVA:.2%}"
exemple_3 = f"""Taux de TVA {taux_de_TVA:.2%}"""
exemple_4 = f'''Taux de TVA {taux_de_TVA:.2%}'''
print(exemple_1)
print(exemple_2)
print(exemple_3)
print(exemple_4)

tva = taux_de_TVA * sous_total
total = sous_total + tva
s_sous_total = "$" + f"{sous_total:,.2f}"
s_tva = "$" + f"{tva:,.2f}"
s_total = "$" + f"{total:,.2f}"

sortie = f"""
Sous-total :  {s_sous_total:>9} 
TVA :         {s_tva:>9} 
Total :       {s_total:>9}
"""
print(sortie)

print (len(s_sous_total))

test = "Nathan le plus beau"
print("N" in test)
print("T" in test)
print("ca" * 2)
print(test[2:6])

print(test.upper())

# Stocke la date du jour dans une variable nommée aujourd'hui
aujourdhui = dt.date.today()

# Stocke une autre date dans une variable appellée fin_decennie
fin_decennie = dt.date(2029,12,31)
date_aujourdhui = f"{aujourdhui:%d/%m/%Y}"

print(aujourdhui)
print(fin_decennie.year)
print(f"{fin_decennie:%A, %d %B, %Y}")
print(date_aujourdhui)

minuit = dt.time()
print(minuit)
maintenant = dt.datetime.now()
print(maintenant)

print(f"{maintenant:%A %d %B %Y à %I:%M%p}")

jour_an = dt.date(2024,1,14)
fete_travail = dt.date(2024,5,1)
duree=dt.timedelta(days=120)
intervalle = fete_travail - jour_an
print(intervalle)
print(jour_an + duree)

soleil = "levé"
if soleil == "couché":
    print ("YO")
print ("Facile")

imposable = False
if imposable:
    print(f"Sous-total : ${total:.2f}")
    montant_TVA = total * taux_de_TVA
    print(f"Montant de la TVA : ${montant_TVA:.2f}")
    total = total + montant_TVA
print (f"Total : ${total:.2f}")

couleur_feu = "jaune"
if couleur_feu == "vert":
    print("Passez")
elif couleur_feu == "rouge":
    print("Stop")
else:
    print("Mefiate")
print("Whatever")

age = 15
if age < 18:
    boisson = "lait"
elif age >= 18 and age < 80:
    boisson = "vin"
else :
    boisson = "jus de pruneau"
print(boisson)

mon_mot = "tuba"
for x in mon_mot:
    print(x)
print("Terminé")

reponses = ["A", "C", "", "D"]
for reponse in reponses:
    if reponse == "":
        print("Incomplet")
        continue
    print(reponse)
print("Boucle terminée")