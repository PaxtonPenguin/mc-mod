colors = ["red", "orange", "yellow", "lime", "green", "light_blue", "cyan", "blue", "pink", "magenta", "purple", "light_gray", "gray", "brown", "black"]
itemcolors = ["Red", "Orange", "Yellow", "Lime", "Green", "LightBlue", "Cyan", "Blue", "Pink", "Magenta", "Purple", "LightGray", "Gray", "Brown", "Black"]
itemscolors = ["WHITE", "RED", "ORANGE", "YELLOW", "LIME", "GREEN", "LIGHT_BLUE", "CYAN", "BLUE", "PINK", "MAGENTA", "PURPLE", "LIGHT_GRAY", "GRAY", "BROWN", "BLACK"]

animal = input("name of animal starting with uppercase letter? ")
wearable = input("name of wearabletype starting with uppercase letter? ")
if animal == "":
    ntype = wearable
    type_ = wearable.lower()
elif wearable == "":
    ntype = animal
    type_ = animal.lower()
else:
    ntype = animal + wearable
    type_ = animal.lower() + "_" + wearable.lower()
typelower = ntype.lower()
type_upper = type_.upper()

with open("itemsadditions.txt", "w+") as file:
    file.write("public static final White" + ntype + "Item WHITE_DYED_" + type_upper + " = Registry.register(BuiltInRegistries.ITEM, ItemIds.WHITE_DYED_" + type_upper + ", new White" + ntype + "Item());\n")
    for color, color2 in zip(itemcolors, itemscolors):
        file.write("public static final " + color + ntype + "Item " + color2 + "_DYED_" + type_upper + " = Registry.register(BuiltInRegistries.ITEM, ItemIds." + color2 + "_DYED_" + type_upper + ", new " + color + ntype + "Item());\n")
        print(color + " done")
print("Items done")