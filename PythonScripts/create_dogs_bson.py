import bson
import random

# Define sample dog breed names
breeds = [
    "Labrador Retriever", "Golden Retriever", "German Shepherd", "Bulldog",
    "Beagle", "Poodle", "Rottweiler", "Dachshund", "Boxer", "Chihuahua"
]

# Generate random data for 50 dogs
dogs = []
for i in range(50):
    dog = {
        "idNu": i + 1,
        "name": f"Dog_{i+1}",
        "breed": random.choice(breeds),
        "age": random.randint(1, 15),
        "agression": random.choice([True, False])
    }
    dogs.append(dog)

# Serialize to BSON and save
bson_data = bson.encode({"dogs": dogs})

with open("new_england_dogs.bson", "wb") as f:
    f.write(bson_data)

print("✅ new_england_dogs.bson file created successfully with 50 entries!")
