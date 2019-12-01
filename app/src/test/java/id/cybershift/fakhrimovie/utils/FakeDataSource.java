package id.cybershift.fakhrimovie.utils;

import java.util.ArrayList;

import id.cybershift.fakhrimovie.data.source.local.entity.MovieEntity;
import id.cybershift.fakhrimovie.data.source.local.entity.TVShowEntity;
import id.cybershift.fakhrimovie.data.source.remote.response.MovieResponse;
import id.cybershift.fakhrimovie.data.source.remote.response.TVShowResponse;

public class FakeDataSource {

    public static ArrayList<MovieEntity> generateDummyRemoteMovies() {
        ArrayList<MovieEntity> listMovies = new ArrayList<>();
        listMovies.add(new MovieEntity(
                "Joker",
                "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
                8.3,
                "2018",
                "/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg"
        ));
        listMovies.add(new MovieEntity(
                "Maleficent: Mistress of Evil",
                "Maleficent and her goddaughter Aurora begin to question the complex family ties that bind them as they are pulled in different directions by impending nuptials, unexpected allies, and dark new forces at play.",
                7.2,
                "2019",
                "/tBuabjEqxzoUBHfbyNbd8ulgy5j.jpg"
        ));
        listMovies.add(new MovieEntity(
                "Terminator: Dark Fate",
                "More than two decades have passed since Sarah Connor prevented Judgment Day, changed the future, and re-wrote the fate of the human race. Dani Ramos is living a simple life in Mexico City with her brother and father when a highly advanced and deadly new Terminator – a Rev-9 – travels back through time to hunt and kill her. Dani's survival depends on her joining forces with two warriors: Grace, an enhanced super-soldier from the future, and a battle-hardened Sarah Connor. As the Rev-9 ruthlessly destroys everything and everyone in its path on the hunt for Dani, the three are led to a T-800 from Sarah’s past that may be their last best hope.",
                6.7,
                "2019",
                "/vqzNJRH4YyquRiWxCCOH0aXggHI.jpg"
        ));
        listMovies.add(new MovieEntity(
                "The Lion King",
                "Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.",
                7.1,
                "2019",
                "/2bXbqYdUdNVa8VIWXVfclP2ICtT.jpg"
        ));
        listMovies.add(new MovieEntity(
                "Spider-Man: Far from Home",
                "Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent.",
                7.6,
                "2019",
                "/lcq8dVxeeOqHvvgcte707K0KVx5.jpg"
        ));
        listMovies.add(new MovieEntity(
                "Cars",
                "Lightning McQueen, a hotshot rookie race car driven to succeed, discovers that life is about the journey, not the finish line, when he finds himself unexpectedly detoured in the sleepy Route 66 town of Radiator Springs. On route across the country to the big Piston Cup Championship in California to compete against two seasoned pros, McQueen gets to know the town's offbeat characters.",
                6.7,
                "2006",
                "/jpfkzbIXgKZqCZAkEkFH2VYF63s.jpg"
        ));
        listMovies.add(new MovieEntity(
                "Fast & Furious Presents: Hobbs & Shaw",
                "Ever since US Diplomatic Security Service Agent Hobbs and lawless outcast Shaw first faced off, they just have swapped smacks and bad words. But when cyber-genetically enhanced anarchist Brixton's ruthless actions threaten the future of humanity, both join forces to defeat him. (A spin-off of “The Fate of the Furious,” focusing on Johnson's Luke Hobbs and Statham's Deckard Shaw.)",
                6.5,
                "2019",
                "/kvpNZAQow5es1tSY6XW2jAZuPPG.jpg"
        ));
        listMovies.add(new MovieEntity(
                "Toy Story 4",
                "Woody has always been confident about his place in the world and that his priority is taking care of his kid, whether that's Andy or Bonnie. But when Bonnie adds a reluctant new toy called \"Forky\" to her room, a road trip adventure alongside old and new friends will show Woody how big the world can be for a toy.",
                7.6,
                "2019",
                "/w9kR8qbmQ01HwnvK4alvnQ2ca0L.jpg"
        ));
        listMovies.add(new MovieEntity(
                "Ip Man 4: The Finale",
                "Ip Man 4 is an upcoming Hong Kong biographical martial arts film directed by Wilson Yip and produced by Raymond Wong. It is the fourth in the Ip Man film series based on the life of the Wing Chun grandmaster of the same name and features Donnie Yen reprising the role. The film began production in April 2018 and ended in July the same year.",
                5.3,
                "2019",
                "/mAWBfTDAmfpvQGMVFuzuVl49N1P.jpg"
        ));
        listMovies.add(new MovieEntity(
                "Zombieland: Double Tap",
                "The group will face a new zombie threat as a new breed of zombie has developed. This new super-zombie type is faster, bigger, and stronger than the previous strain of zombies and harder to kill. These super-zombies have started grouping up into a horde going from city to city leaving a path of destruction behind them.",
                7.5,
                "2019",
                "/pIcV8XXIIvJCbtPoxF9qHMKdRr2.jpg"
        ));
        listMovies.add(new MovieEntity(
                "El Camino: A Breaking Bad Movie",
                "In the wake of his dramatic escape from captivity, Jesse Pinkman must come to terms with his past in order to forge some kind of future.",
                7.1,
                "2019",
                "/ePXuKdXZuJx8hHMNr2yM4jY2L7Z.jpg"
        ));
        listMovies.add(new MovieEntity(
                "Scary Stories to Tell in the Dark",
                "The shadow of the Bellows family has loomed large in the small town of Mill Valley for generations. It's in a mansion that young Sarah Bellows turns her tortured life and horrible secrets into a series of scary stories. These terrifying tales soon have a way of becoming all too real for a group of unsuspecting teens who stumble upon Sarah's spooky home.",
                6.3,
                "2019",
                "/d0FWbzrmm99BTfUqf1Lbjl2zu3S.jpg"
        ));
        return listMovies;
    }

    public static ArrayList<TVShowEntity> generateDummyRemoteTVShows() {
        ArrayList<TVShowEntity> listTVShows = new ArrayList<>();
        listTVShows.add(new TVShowEntity(
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                5.8,
                "2012",
                "/mo0FP1GxOFZT4UDde7RFDz5APXF.jpg"
        ));
        listTVShows.add(new TVShowEntity(
                "Fear the Walking Dead",
                "What did the world look like as it was transforming into the horrifying apocalypse depicted in \"The Walking Dead\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.",
                6.3,
                "2015",
                "/lZMb3R3e5vqukPbeDMeyYGf2ZNG.jpg"
        ));
        listTVShows.add(new TVShowEntity(
                "Supernatural",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. ",
                7.4,
                "2005",
                "/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg"
        ));
        listTVShows.add(new TVShowEntity(
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                6.7,
                "2014",
                "/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg"
        ));
        listTVShows.add(new TVShowEntity(
                "The Simpsons",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                7.1,
                "1989",
                "/yTZQkSsxUFJZJe67IenRM0AEklc.jpg"
        ));
        listTVShows.add(new TVShowEntity(
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                6.5,
                "1999",
                "/gBGUL1UTUNmdRQT8gA1LUV4yg39.jpg"
        ));
        listTVShows.add(new TVShowEntity(
                "Batwoman",
                "Armed with a great passion for social justice and with a great facility to always say what she thinks, Kate Kane is known in the streets of Gotham as Batwoman, a lesbian highly trained to fight crime that resurfaces in the city. However, before becoming a savior, she must fight the demons that prevent her from being the symbol of the hope of a corrupt city.",
                6.2,
                "2019",
                "/jnaimWkIVSD9IInmZPyLYarSvvc.jpg"
        ));
        listTVShows.add(new TVShowEntity(
                "Law & Order: Special Victims Unit",
                "In the criminal justice system, sexually-based offenses are considered especially heinous. In New York City, the dedicated detectives who investigate these vicious felonies are members of an elite squad known as the Special Victims Unit. These are their stories.",
                6.4,
                "1999",
                "/6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg"
        ));
        listTVShows.add(new TVShowEntity(
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                6.5,
                "2019",
                "/nclcURTdlqVbDr6HPmrHC5X4qUu.jpg"
        ));
        listTVShows.add(new TVShowEntity(
                "ハンターｘハンター",
                "Twelve-year-old Gon Freecss one day discovers that the father he had always been told was dead was alive and well. His Father, Ging, is a Hunter—a member of society's elite with a license to go anywhere or do almost anything. Gon, determined to follow in his father's footsteps, decides to take the Hunter Examination and eventually find his father to prove himself as a Hunter in his own right. But on the way, he learns that there is more to becoming a Hunter than previously thought, and the challenges that he must face are considered the toughest in the world.",
                8.3,
                "2011",
                "/yWBcBIO9OrF3E85C5Arols6QNnG.jpg"
        ));
        listTVShows.add(new TVShowEntity(
                "South Park",
                "Follows the misadventures of four irreverent grade-schoolers in the quiet, dysfunctional town of South Park, Colorado.",
                7.8,
                "1997",
                "/v9zc0cZpy5aPSfAy6Tgb6I1zWgV.jpg"
        ));
        listTVShows.add(new TVShowEntity(
                "Breaking Bad",
                "When Walter White, a New Mexico chemistry teacher, is diagnosed with Stage III cancer and given a prognosis of only two years left to live. He becomes filled with a sense of fearlessness and an unrelenting desire to secure his family's financial future at any cost as he enters the dangerous world of drugs and crime.",
                8.4,
                "2008",
                "/1yeVJox3rjo2jBKrrihIMj7uoS9.jpg"
        ));
        return listTVShows;
    }

    public static MovieEntity getMovie(int position) {
        return generateDummyRemoteMovies().get(position);
    }

    public static TVShowEntity getTVShow(int position) {
        return generateDummyRemoteTVShows().get(position);
    }

    public static ArrayList<MovieResponse> getMoviesData() {
        ArrayList<MovieResponse> listMovies = new ArrayList<>();
        listMovies.add(new MovieResponse(
                "Joker",
                "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
                8.3,
                "2018",
                "/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg"
        ));
        listMovies.add(new MovieResponse(
                "Maleficent: Mistress of Evil",
                "Maleficent and her goddaughter Aurora begin to question the complex family ties that bind them as they are pulled in different directions by impending nuptials, unexpected allies, and dark new forces at play.",
                7.2,
                "2019",
                "/tBuabjEqxzoUBHfbyNbd8ulgy5j.jpg"
        ));
        listMovies.add(new MovieResponse(
                "Terminator: Dark Fate",
                "More than two decades have passed since Sarah Connor prevented Judgment Day, changed the future, and re-wrote the fate of the human race. Dani Ramos is living a simple life in Mexico City with her brother and father when a highly advanced and deadly new Terminator – a Rev-9 – travels back through time to hunt and kill her. Dani's survival depends on her joining forces with two warriors: Grace, an enhanced super-soldier from the future, and a battle-hardened Sarah Connor. As the Rev-9 ruthlessly destroys everything and everyone in its path on the hunt for Dani, the three are led to a T-800 from Sarah’s past that may be their last best hope.",
                6.7,
                "2019",
                "/vqzNJRH4YyquRiWxCCOH0aXggHI.jpg"
        ));
        listMovies.add(new MovieResponse(
                "The Lion King",
                "Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.",
                7.1,
                "2019",
                "/2bXbqYdUdNVa8VIWXVfclP2ICtT.jpg"
        ));
        listMovies.add(new MovieResponse(
                "Spider-Man: Far from Home",
                "Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent.",
                7.6,
                "2019",
                "/lcq8dVxeeOqHvvgcte707K0KVx5.jpg"
        ));
        listMovies.add(new MovieResponse(
                "Cars",
                "Lightning McQueen, a hotshot rookie race car driven to succeed, discovers that life is about the journey, not the finish line, when he finds himself unexpectedly detoured in the sleepy Route 66 town of Radiator Springs. On route across the country to the big Piston Cup Championship in California to compete against two seasoned pros, McQueen gets to know the town's offbeat characters.",
                6.7,
                "2006",
                "/jpfkzbIXgKZqCZAkEkFH2VYF63s.jpg"
        ));
        listMovies.add(new MovieResponse(
                "Fast & Furious Presents: Hobbs & Shaw",
                "Ever since US Diplomatic Security Service Agent Hobbs and lawless outcast Shaw first faced off, they just have swapped smacks and bad words. But when cyber-genetically enhanced anarchist Brixton's ruthless actions threaten the future of humanity, both join forces to defeat him. (A spin-off of “The Fate of the Furious,” focusing on Johnson's Luke Hobbs and Statham's Deckard Shaw.)",
                6.5,
                "2019",
                "/kvpNZAQow5es1tSY6XW2jAZuPPG.jpg"
        ));
        listMovies.add(new MovieResponse(
                "Toy Story 4",
                "Woody has always been confident about his place in the world and that his priority is taking care of his kid, whether that's Andy or Bonnie. But when Bonnie adds a reluctant new toy called \"Forky\" to her room, a road trip adventure alongside old and new friends will show Woody how big the world can be for a toy.",
                7.6,
                "2019",
                "/w9kR8qbmQ01HwnvK4alvnQ2ca0L.jpg"
        ));
        listMovies.add(new MovieResponse(
                "Ip Man 4: The Finale",
                "Ip Man 4 is an upcoming Hong Kong biographical martial arts film directed by Wilson Yip and produced by Raymond Wong. It is the fourth in the Ip Man film series based on the life of the Wing Chun grandmaster of the same name and features Donnie Yen reprising the role. The film began production in April 2018 and ended in July the same year.",
                5.3,
                "2019",
                "/mAWBfTDAmfpvQGMVFuzuVl49N1P.jpg"
        ));
        listMovies.add(new MovieResponse(
                "Zombieland: Double Tap",
                "The group will face a new zombie threat as a new breed of zombie has developed. This new super-zombie type is faster, bigger, and stronger than the previous strain of zombies and harder to kill. These super-zombies have started grouping up into a horde going from city to city leaving a path of destruction behind them.",
                7.5,
                "2019",
                "/pIcV8XXIIvJCbtPoxF9qHMKdRr2.jpg"
        ));
        listMovies.add(new MovieResponse(
                "El Camino: A Breaking Bad Movie",
                "In the wake of his dramatic escape from captivity, Jesse Pinkman must come to terms with his past in order to forge some kind of future.",
                7.1,
                "2019",
                "/ePXuKdXZuJx8hHMNr2yM4jY2L7Z.jpg"
        ));
        listMovies.add(new MovieResponse(
                "Scary Stories to Tell in the Dark",
                "The shadow of the Bellows family has loomed large in the small town of Mill Valley for generations. It's in a mansion that young Sarah Bellows turns her tortured life and horrible secrets into a series of scary stories. These terrifying tales soon have a way of becoming all too real for a group of unsuspecting teens who stumble upon Sarah's spooky home.",
                6.3,
                "2019",
                "/d0FWbzrmm99BTfUqf1Lbjl2zu3S.jpg"
        ));
        return listMovies;
    }

    public static ArrayList<TVShowResponse> getTVShowsData() {
        ArrayList<TVShowResponse> listTVShows = new ArrayList<>();
        listTVShows.add(new TVShowResponse(
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                5.8,
                "2012",
                "/mo0FP1GxOFZT4UDde7RFDz5APXF.jpg"
        ));
        listTVShows.add(new TVShowResponse(
                "Fear the Walking Dead",
                "What did the world look like as it was transforming into the horrifying apocalypse depicted in \"The Walking Dead\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.",
                6.3,
                "2015",
                "/lZMb3R3e5vqukPbeDMeyYGf2ZNG.jpg"
        ));
        listTVShows.add(new TVShowResponse(
                "Supernatural",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. ",
                7.4,
                "2005",
                "/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg"
        ));
        listTVShows.add(new TVShowResponse(
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                6.7,
                "2014",
                "/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg"
        ));
        listTVShows.add(new TVShowResponse(
                "The Simpsons",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                7.1,
                "1989",
                "/yTZQkSsxUFJZJe67IenRM0AEklc.jpg"
        ));
        listTVShows.add(new TVShowResponse(
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                6.5,
                "1999",
                "/gBGUL1UTUNmdRQT8gA1LUV4yg39.jpg"
        ));
        listTVShows.add(new TVShowResponse(
                "Batwoman",
                "Armed with a great passion for social justice and with a great facility to always say what she thinks, Kate Kane is known in the streets of Gotham as Batwoman, a lesbian highly trained to fight crime that resurfaces in the city. However, before becoming a savior, she must fight the demons that prevent her from being the symbol of the hope of a corrupt city.",
                6.2,
                "2019",
                "/jnaimWkIVSD9IInmZPyLYarSvvc.jpg"
        ));
        listTVShows.add(new TVShowResponse(
                "Law & Order: Special Victims Unit",
                "In the criminal justice system, sexually-based offenses are considered especially heinous. In New York City, the dedicated detectives who investigate these vicious felonies are members of an elite squad known as the Special Victims Unit. These are their stories.",
                6.4,
                "1999",
                "/6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg"
        ));
        listTVShows.add(new TVShowResponse(
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                6.5,
                "2019",
                "/nclcURTdlqVbDr6HPmrHC5X4qUu.jpg"
        ));
        listTVShows.add(new TVShowResponse(
                "ハンターｘハンター",
                "Twelve-year-old Gon Freecss one day discovers that the father he had always been told was dead was alive and well. His Father, Ging, is a Hunter—a member of society's elite with a license to go anywhere or do almost anything. Gon, determined to follow in his father's footsteps, decides to take the Hunter Examination and eventually find his father to prove himself as a Hunter in his own right. But on the way, he learns that there is more to becoming a Hunter than previously thought, and the challenges that he must face are considered the toughest in the world.",
                8.3,
                "2011",
                "/yWBcBIO9OrF3E85C5Arols6QNnG.jpg"
        ));
        listTVShows.add(new TVShowResponse(
                "South Park",
                "Follows the misadventures of four irreverent grade-schoolers in the quiet, dysfunctional town of South Park, Colorado.",
                7.8,
                "1997",
                "/v9zc0cZpy5aPSfAy6Tgb6I1zWgV.jpg"
        ));
        listTVShows.add(new TVShowResponse(
                "Breaking Bad",
                "When Walter White, a New Mexico chemistry teacher, is diagnosed with Stage III cancer and given a prognosis of only two years left to live. He becomes filled with a sense of fearlessness and an unrelenting desire to secure his family's financial future at any cost as he enters the dangerous world of drugs and crime.",
                8.4,
                "2008",
                "/1yeVJox3rjo2jBKrrihIMj7uoS9.jpg"
        ));
        return listTVShows;
    }

}
