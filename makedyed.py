import shutil

colors = ["red", "orange", "yellow", "lime", "green", "light_blue", "cyan", "blue", "pink", "magenta", "purple", "light_gray", "gray", "brown", "black"]
itemcolors = ["Red", "Orange", "Yellow", "Lime", "Green", "LightBlue", "Cyan", "Blue", "Pink", "Magenta", "Purple", "LightGray", "Gray", "Brown", "Black"]
itemscolors = ["WHITE", "RED", "ORANGE", "YELLOW", "LIME", "GREEN", "LIGHT_BLUE", "CYAN", "BLUE", "PINK", "MAGENTA", "PURPLE", "LIGHT_GRAY", "GRAY", "BROWN", "BLACK"]

animal = input("name of animal starting with uppercase letter? ")
wearable = input("name of wearabletype starting with uppercase letter? ")
if animal == "":
    ntype = wearable
    type_ = wearable.lower()
elif wearable = "":
    ntype = animal
    type_ = animal.lower()
else:
    ntype = animal + wearable
    type_ = animal.lower() + "_" + wearable.lower()
typelower = ntype.lower()
type_upper = type_.upper()

source = "/src/main/java/paxton/pixton/"
dyefiles = source + "dyed/" + ntype + "s/"

rendererfile = dyefiles + "renderers/white_dyed_" + type_ + ".java"
for color in colors:
    shutil.copyfile(rendererfile, dyefiles + "renderers/" +  color + "_dyed_" + type_ + ".java")
    with open(dyefiles + "renderers/" +  color + "_dyed_" + type_ + ".java", 'r') as file:
        data = file.read()
        data = data.replace("white", color)
    with open(dyefiles + "renderers/" +  color + "_dyed_" + type_ + ".java", 'w') as file:
        file.write(data)
    print(color + " done")
print("renderers done")

itemfile = dyefiles + "items/white_dyed_" + ntype + ".java"
for color in itemcolors:
    shutil.copyfile(rendererfile, dyefiles + "items/" +  color + "_dyed_" + ntype + "Item.java")
    with open(dyefiles + "items/" +  color + "_dyed_" + ntype + "Item.java", 'r') as file:
        data = file.read()
        data = data.replace("White", color)
        for color2 in itemscolors:
            data2 = file.read()
            data2 = data.replace("WHITE", color2)
    with open(dyefiles + "items/" +  color + "_dyed_" + ntype + "Item.java", 'w') as file:
        file.write(data)
        file.write(data2)
            
    print(color + " done")
print("items done")

with open("itemidsadditions.txt", "w+") as file:
    file.write('public static final ResourceKey<Item> WHITE_DYED_CAT_TAIL = create("white_dyed_cat_tail");\n')
    for color, color2 in zip(colors, itemscolors):
        file.write('public static final ResourceKey<Item> ' + color2 + '_DYED_' + type_upper + ' = create("' + color + '_dyed_' type_ '");\n')
        print(color + " done")
print("ItemIds done")

with open("itemsadditions.txt", "w+") as file:
    file.write("public static final WhiteCatTailItem WHITE_DYED_CAT_TAIL = Registry.register(BuiltInRegistries.ITEM, ItemIds.WHITE_DYED_CAT_TAIL, new WhiteCatTailItem());\n")
    for color, color2 in zip(itemcolors, itemscolors):
        file.write("public static final " + color + ntype + "Item " + color2 "_DYED_" + type_upper + " = Registry.register(BuiltInRegistries.ITEM, ItemIds." + color2 "_DYED_" + type_upper + ", new " + color + ntype + "Item());\n")
        print(color + " done")
print("Items done")

with open("creativetabadditions.txt", "w+") as file:
    file.write("output.accept(Items.WHITE_DYED_" + type_upper + ");\n")
    for color in itemscolors:
        file.write("output.accept(Items." + color + "_DYED_" + type_upper + ");\n")
    print(color + " done")
print("creative tab done")

recs = "./src/main/resources/assets/pixton/"
itemmodel = recs + "models/item/"
clientitem = recs + "items/"

itemmodelfile = itemmodel + "white_dyed_" + type_ + ".json"
for color in colors:
    shutil.copyfile(itemmodelfile, itemmodel + color + "_dyed_" + type_ + ".json")
    with open(itemmodel + color + "_dyed_" + type_ + ".json", "r") as file:
        data = file.read()
        data = data.replace("white", color)
    with open(itemmodel + color + "_dyed_" + type_ + ".json", "w") as file:    
        file.write(data)
    print(color + " done")
print("item models done")

clientitemfile = clientitem + "white_dyed_" + type_ + ".json"
for color in colors:
    shutil.copyfile(clientitemfile, clientitem + color + "_dyed_" + type_ + ".json")
    with open(clientitem + color + "_dyed_" + type_ + ".json", "r") as file:
        data = file.read()
        data = data.replace("white", color)
    with open(clientitem + color + "_dyed_" + type_ + ".json", "w") as file:
        file.write(data)
    print(color + " done")
print("client items done")

with open("langadditions.txt", "w+") as file:
    file.write('"item.pixton.white_dyed_' + type_ + '": "White Dyed' + animal + " " + wearable + '",\n')
    for color, color2 in zip(colors, itemcolors):
        file.write('"item.pixton.' + color + '_dyed_' + type_ + '": "' + color2 + ' Dyed ' + animal + " " + wearable + '",\n')
        print(color + " done")
print("ItemIds done")

recipes = "./src/main/resources/data/pixton/recipe/"
recipefile = recipes + "white_dyed_" + type_ + ".json"
for color in colors:
    shutil.copyfile(recipefile, recipes + color + "_dyed_" + type_ + ".json")
    with open(recipes + color + "_dyed_" + type_ + ".json", "r") as file:
        data = file.read()
        data = data.replace("white", color)
    with open(recipes + color + "_dyed_" + type_ + ".json", "w") as file:    
        file.write(data)
    print(color + " done")
print("item models done")

print("everything done")
