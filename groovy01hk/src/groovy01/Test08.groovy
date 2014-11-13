package groovy01


//반복문

//while문
i = 0
while (i < 10){
	print i
	i++
}

println "\n--------------------"

//for문
for (int i = 0; i < 5; i++) print i+","
println "\n--------------------"
for (k in 0..6) print k+","
println "\n--------------------"
for (i in [100,90,80,"홍길동",true]) {
	print i
	print ","
}
println"\n--------------------"
for (c in "오호라!그렇군요!") print c + ","

println"\n--------------------"
map = ["name" : "홍길동", "kor" : 100, "eng" : 90, "math" : 80]
for(e in map) println e.key + "," + e.value

println"--------------------"
for (v in map.values()) print v + ","

