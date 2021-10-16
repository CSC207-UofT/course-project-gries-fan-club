# JChef CRC Cards

Welcome to our CRC cards for phase 0.
We have already gone through many iterations and challenges in designing these cards and as such we have a few notes to give.

First, our terminology does not directly align with that of Clean Architecture.
For example, to us an entity is not a high level object.
Rather, it is more akin to a data object.
It is vital to the program, but largely does not that much.

For the moment, we have forgone including the lowest level of the CRC cards (I.E. CLI interfaces).
This is because we do not want to focus on details at this time.
Our current set up will allow for us to plugin what ever user interface we want at a later date.
This is also because we are undecided whether we would want to make this tool CLI only or perhaps an Android app.
This also allowed us to focus on constructing a strong and clean architecture to help guide the rest of our coding.
Importantly, this decision was pre-meditated and informed; not an excuse for doing less on the cards as more effort was directed to the rest of them.

Each "level" folder corresponds to a level in the Clean Architecture sense.
Within, each file represents a component, or group of related classes that will change for similar reasons.

Lastly, we developed these cards with an [online CRC service](https://echeung.me/crcmaker/).
Sadly, the service is not too feature rich and this meant we had to manually split our cards into different files to help the overall component structure of our program be recognised.
Uploading the files to this website will help you visualize the cards, but they remain fairly legible in JSON form.
There is also a [compiled PDF](CRC%20Cards%20JChef.pdf) in this directory which shows connections between our cards.
