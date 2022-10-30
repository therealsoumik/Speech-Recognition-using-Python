import pyttsx3  
# initialize Text-to-speech engine  
engine = pyttsx3.init()  
# convert this text to speech  
text = "Python is a great programming language"  
engine.say(text)  
# play the speech  
engine.runAndWait()  