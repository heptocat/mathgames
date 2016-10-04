import random as r
r.seed()
#actualize

# values

a=r.randrange(10)
b=r.randrange(10)
c=a-b
print("questo programma to fa ripassare le sottrazioni")

print("What is", a, "-", b, "?")
x=c+1
t=0
#for i in range(4):
while x != c:
	#counter
	t=t+1
	x=input()
	try:
		x=int(x)
	except:
		print(x, "is not a number")
		#t=t-1
		continue
	if x==c:
		print(x, "is right. Well done!")
		#stop program
		#break
	#elif c-5<=x<=c+5:
	#	print(x, "is almost right")
	else:
		print(x, "is wrong. Mwahahahahahaha")
print("The right answer:", c)
print("attempts:", t)
