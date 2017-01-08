import math
def pieProgress(callPercentage, callX, callY):
    if callPercentage == 0:
        return False
    if callPercentage < 75 & callPercentage >= 50 & callX < 50 & callY >= 50:
        return False
    if callPercentage <= 50 & callPercentage >= 25 & callX > 50:
        return False
    if callPercentage <= 25 & (callX < 50 | callY < 50):
        return False
    if math.sqrt(math.pow(50 - callX, 2) + math.pow(50 - callY, 2)) > 50:
        return False
    angle = to360(math.degrees(math.atan2(callY - 50, callX - 50)))
    percentage = angle * 100 / 360

    if percentage < callPercentage:
        return True

    return False

def to360(angle):
    #
    #
    if angle < 0:
        return 360 + angle
    else:
        return angle

with open('test_input.txt') as file:
    input = file.readlines()
    output = ""
    T = input[0]
    input.pop(0)
    i = 1
    for w in input:
        inputLine = w.split()
        if pieProgress(int(float(inputLine[0])), int(float(inputLine[1])), int(float(inputLine[2]))):
            output += "Case #" + str(i) + ": black "+inputLine[0]+" "+inputLine[1]+" "+inputLine[2]+"\n"
            output += "Case #" + str(i) + ": black "+str(int(float(inputLine[0])))+" "+str(int(float(inputLine[1])))+" "+str(int(float(inputLine[2])))+"\n"
        else:
            output += "Case #" + str(i) + ": white "+inputLine[0]+" "+inputLine[1]+" "+inputLine[2]+"\n"
   #     output +="Case #"+str(i)+": "+x
        i += 1
with open("test_output1.txt", "w") as text_file:
    text_file.write(output)

