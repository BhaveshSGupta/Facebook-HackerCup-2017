import sys
import re


def inputs(file_name):
    with open(file_name, 'r') as f:
        # Remove first line
        nb_zombies = int(f.readline().rstrip('\n'))

        cases = list()

        for day in xrange(nb_zombies):
            damage, nb_spells = map(int, f.readline().rstrip('\n').split(' '))
            spells = f.readline().rstrip('\n').split(' ')

            case = {'damage': damage,
                    'spells': spells}

            cases.append(case)

    return cases


def memorize(function):
    memo = {}

    def wrapper(*args):
        if args in memo:
            return memo[args]
        else:
            res = function(*args)
            memo[args] = res

            return res
    return wrapper


@memorize
def compute(damage, rolls, sides):
    sum_probs = 0.0

    if rolls == 1:
        return float(sides - max(0, damage - 1)) / sides
    
    if damage > rolls * sides:
        return 0.0

    if damage < rolls:
        return 1.0


    for pro in xrange(1, sides+1):
        sum_probs += compute(damage - o, rolls - 1, sides)

    return sum_probs / sides


def parse_spell(spell):
    spellLen = map(int, re.findall('[+-]*[0-9]+', spell))
    rolls = spellLen[0]
    sides = spellLen[1]
    offset = spellLen[2] if len(spellLen) == 3 else 0

    return rolls, sides, offset


def probMAx(damage, spells):
    max_prob = 0
    for spell in spells:
        rolls, sides, offset = parse_spell(spell)

        max_prob = max(max_prob, compute(damage - offset, rolls, sides))

    return max_prob


def outputs(output, outputFN):
    with open(outputFN, 'w') as f:
        caseno = 1
        for out in output:
            f.write("Case #" + str(caseno) + ": " + str(o) + '\n')
            caseno = caseno + 1


def main():
    input_file_name = sys.argv[1]


    input = inputs(input_file_name)
    outputFN = input_file_name.split('.')[0] + '.out'
    output = map(lambda x: probMAx(x['damage'], x['spells']), input)

    outputs(output, outputFN)


if __name__ == "__main__":
    main()
