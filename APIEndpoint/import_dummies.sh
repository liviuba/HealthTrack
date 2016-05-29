#/bin/bash

mongo dummies --eval "db.dropDatabase()"

mongoimport --db dummies --collection users --file ../android-app/app/src/main/assets/Mocks/User.json

for i in `ls ../android-app/app/src/main/assets/Mocks/Product*`; do
  mongoimport --db dummies --collection products --file $i
done

for i in `ls ../android-app/app/src/main/assets/Mocks/BasketItem*`; do
  mongoimport --db dummies --collection basketItems --file $i
done

for i in `ls ../android-app/app/src/main/assets/Mocks/Basket*`; do
  mongoimport --db dummies --collection baskets --file $i
done