import math

def circleContains(p,x,y):
    if p == 0:
        return False
    if math.sqrt(math.pow(50 - x, 2) + math.pow(50 - y, 2)) > 50:
        return False

    angle = to360(math.degrees(math.atan2(y - 50, x - 50)))
    percentage = angle * 100 / 360

    if percentage > p:
        return False

    return True

def to360(angle):
    if angle < 0:
        return 360 + angle
    else:
        return angle

with open('progress_pie_example_input.txt') as f:
    lines = f.readlines()
    output = ""
    n = lines[0]
    lines.pop(0)
    i = 1
    for x in lines:
        line = x.split()
        if circleContains(long(line[0]),long(line[1]),long(line[2])):
            output += "Case #" + str(i) + ": black\n"
        else:
            output += "Case #" + str(i) + ": white\n"
        i += 1
with open("output.txt", "w") as text_file:
    text_file.write(output)
