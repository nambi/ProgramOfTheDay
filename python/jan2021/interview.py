
print "Hello Dear, Welcome to AAS clinic \n Station X, Moon"

print "Lets answer some basic questions for an appointment"

name = raw_input("Whats your name : ")

print "Thank you"

place = raw_input("where do you live ? ")

print "Great"

if place == 'earth' :
	print "Thank you "+name+". we dont offer service at "+place +" or even on any earth places yet."
else :
	print "Thank you "+name+". Nice to know that you live at "+place +". How May I help you?"



