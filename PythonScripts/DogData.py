import bson, json

with open("DogData.bson", "rb") as f:
    data = bson.decode_all(f.read())

# Save to JSON
with open("Animals.json", "w") as f:
    json.dump(data, f, indent=2)

print("✅ Converted to Animals.json")
