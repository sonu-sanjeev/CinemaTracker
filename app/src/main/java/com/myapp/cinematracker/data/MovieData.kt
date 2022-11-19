package com.myapp.cinematracker.data

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.annotations.SerializedName
import java.lang.RuntimeException

data class MovieData(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val movieTitle: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("original_language") val language: String,
    @SerializedName("vote_average") val rating: Float
)


data class MovieResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movieList: List<MovieData>
)


fun String.convertResponse(gson: Gson): MovieResponse {
    return try {
        gson.fromJson(staticResponse, MovieResponse::class.java)
    } catch (ex: JsonSyntaxException){
        throw RuntimeException(ex.message)
    }
}

val staticResponse = "{\"dates\":{\"maximum\":\"2022-11-24\",\"minimum\":\"2022-10-07\"},\"page\":1,\"results\":[{\"adult\":false,\"backdrop_path\":\"/bQXAqRx2Fgc46uCVWgoPz5L5Dtr.jpg\",\"genre_ids\":[28,14,878],\"id\":436270,\"original_language\":\"en\",\"original_title\":\"Black Adam\",\"overview\":\"Nearly 5,000 years after he was bestowed with the almighty powers of the Egyptian gods—and imprisoned just as quickly—Black Adam is freed from his earthly tomb, ready to unleash his unique form of justice on the modern world.\",\"popularity\":8684.035,\"poster_path\":\"/pFlaoHTZeyNkG83vxsAJiGzfSsa.jpg\",\"release_date\":\"2022-10-19\",\"title\":\"Black Adam\",\"video\":false,\"vote_average\":6.9,\"vote_count\":1158},{\"adult\":false,\"backdrop_path\":\"/olPXihyFeeNvnaD6IOBltgIV1FU.jpg\",\"genre_ids\":[27,9648,53],\"id\":882598,\"original_language\":\"en\",\"original_title\":\"Smile\",\"overview\":\"After witnessing a bizarre, traumatic incident involving a patient, Dr. Rose Cotter starts experiencing frightening occurrences that she can't explain. As an overwhelming terror begins taking over her life, Rose must confront her troubling past in order to survive and escape her horrifying new reality.\",\"popularity\":3871.704,\"poster_path\":\"/aPqcQwu4VGEewPhagWNncDbJ9Xp.jpg\",\"release_date\":\"2022-09-23\",\"title\":\"Smile\",\"video\":false,\"vote_average\":6.8,\"vote_count\":638},{\"adult\":false,\"backdrop_path\":\"/yYrvN5WFeGYjJnRzhY0QXuo4Isw.jpg\",\"genre_ids\":[28,12,878],\"id\":505642,\"original_language\":\"en\",\"original_title\":\"Black Panther: Wakanda Forever\",\"overview\":\"Queen Ramonda, Shuri, M’Baku, Okoye and the Dora Milaje fight to protect their nation from intervening world powers in the wake of King T’Challa’s death. As the Wakandans strive to embrace their next chapter, the heroes must band together with the help of War Dog Nakia and Everett Ross and forge a new path for the kingdom of Wakanda.\",\"popularity\":3441.331,\"poster_path\":\"/sv1xJUazXeYqALzczSZ3O6nkH75.jpg\",\"release_date\":\"2022-11-09\",\"title\":\"Black Panther: Wakanda Forever\",\"video\":false,\"vote_average\":7.5,\"vote_count\":747},{\"adult\":false,\"backdrop_path\":\"/y5Z0WesTjvn59jP6yo459eUsbli.jpg\",\"genre_ids\":[27,53],\"id\":663712,\"original_language\":\"en\",\"original_title\":\"Terrifier 2\",\"overview\":\"After being resurrected by a sinister entity, Art the Clown returns to Miles County where he must hunt down and destroy a teenage girl and her younger brother on Halloween night.  As the body count rises, the siblings fight to stay alive while uncovering the true nature of Art's evil intent.\",\"popularity\":2033.463,\"poster_path\":\"/b6IRp6Pl2Fsq37r9jFhGoLtaqHm.jpg\",\"release_date\":\"2022-10-06\",\"title\":\"Terrifier 2\",\"video\":false,\"vote_average\":7,\"vote_count\":616},{\"adult\":false,\"backdrop_path\":\"/tUBN1paMQ1tmVA5Sjy1ZjPWVsiF.jpg\",\"genre_ids\":[12,16,35,10751,14],\"id\":676701,\"original_language\":\"es\",\"original_title\":\"Tadeo Jones 3: La Tabla Esmeralda\",\"overview\":\"Tad would love for his archeologist colleagues to accept him as one of their own, but he always messes everything up. Tad accidentally destroys a sarcophagus and unleashes an ancient spell endangering the lives of his friends: Mummy, Jeff and Belzoni. With everyone against him and only helped by Sara, he sets off on an adventure that will take him from Mexico to Chicago and from Paris to Egypt, in order to put an end to the curse of the Mummy.\",\"popularity\":1979.806,\"poster_path\":\"/jvIVl8zdNSOAJImw1elQEzxStMN.jpg\",\"release_date\":\"2022-08-24\",\"title\":\"Tad the Lost Explorer and the Emerald Tablet\",\"video\":false,\"vote_average\":7.9,\"vote_count\":86},{\"adult\":false,\"backdrop_path\":\"/f9g3R9gq0bASip9RnK2H56dbb5j.jpg\",\"genre_ids\":[53],\"id\":979924,\"original_language\":\"en\",\"original_title\":\"On the Line\",\"overview\":\"A provocative and edgy radio host must play a dangerous game of cat and mouse with a mysterious caller who's kidnapped his family and is threatening to blow up the whole station.\",\"popularity\":1439.993,\"poster_path\":\"/jVmWI8PqoVTHCnrLYAcyrclzeY0.jpg\",\"release_date\":\"2022-10-31\",\"title\":\"On the Line\",\"video\":false,\"vote_average\":6.5,\"vote_count\":120},{\"adult\":false,\"backdrop_path\":\"/gVecEIEZLZg3pV5CACXAB48I6au.jpg\",\"genre_ids\":[80,18,9648,53],\"id\":862965,\"original_language\":\"en\",\"original_title\":\"Emily the Criminal\",\"overview\":\"Emily, who is saddled with student debt and locked out of the job market due to a minor criminal record, gets involved in a credit card scam that pulls her into the criminal underworld of Los Angeles, ultimately leading to deadly consequences.\",\"popularity\":1548.549,\"poster_path\":\"/iZvzMpREGiqDQ5eYbx8z70qPgst.jpg\",\"release_date\":\"2022-08-12\",\"title\":\"Emily the Criminal\",\"video\":false,\"vote_average\":6.8,\"vote_count\":181},{\"adult\":false,\"backdrop_path\":\"/1DBDwevWS8OhiT3wqqlW7KGPd6m.jpg\",\"genre_ids\":[53],\"id\":985939,\"original_language\":\"en\",\"original_title\":\"Fall\",\"overview\":\"For best friends Becky and Hunter, life is all about conquering fears and pushing limits. But after they climb 2,000 feet to the top of a remote, abandoned radio tower, they find themselves stranded with no way down. Now Becky and Hunter’s expert climbing skills will be put to the ultimate test as they desperately fight to survive the elements, a lack of supplies, and vertigo-inducing heights\",\"popularity\":1176.073,\"poster_path\":\"/spCAxD99U1A6jsiePFoqdEcY0dG.jpg\",\"release_date\":\"2022-08-11\",\"title\":\"Fall\",\"video\":false,\"vote_average\":7.3,\"vote_count\":1745},{\"adult\":false,\"backdrop_path\":\"/mqsPyyeDCBAghXyjbw4TfEYwljw.jpg\",\"genre_ids\":[10752,18,28],\"id\":49046,\"original_language\":\"de\",\"original_title\":\"Im Westen nichts Neues\",\"overview\":\"Paul Baumer and his friends Albert and Muller, egged on by romantic dreams of heroism, voluntarily enlist in the German army. Full of excitement and patriotic fervour, the boys enthusiastically march into a war they believe in. But once on the Western Front, they discover the soul-destroying horror of World War I.\",\"popularity\":1138.267,\"poster_path\":\"/hYqOjJ7Gh1fbqXrxlIao1g8ZehF.jpg\",\"release_date\":\"2022-10-07\",\"title\":\"All Quiet on the Western Front\",\"video\":false,\"vote_average\":7.8,\"vote_count\":818},{\"adult\":false,\"backdrop_path\":\"/5GA3vV1aWWHTSDO5eno8V5zDo8r.jpg\",\"genre_ids\":[27,53],\"id\":760161,\"original_language\":\"en\",\"original_title\":\"Orphan: First Kill\",\"overview\":\"After escaping from an Estonian psychiatric facility, Leena Klammer travels to America by impersonating Esther, the missing daughter of a wealthy family. But when her mask starts to slip, she is put against a mother who will protect her family from the murderous “child” at any cost.\",\"popularity\":957.873,\"poster_path\":\"/pHkKbIRoCe7zIFvqan9LFSaQAde.jpg\",\"release_date\":\"2022-07-27\",\"title\":\"Orphan: First Kill\",\"video\":false,\"vote_average\":6.8,\"vote_count\":1301},{\"adult\":false,\"backdrop_path\":\"/tIX6j3NzadlwGcJ52nuWdmtOQkg.jpg\",\"genre_ids\":[27,53,9648],\"id\":717728,\"original_language\":\"en\",\"original_title\":\"Jeepers Creepers: Reborn\",\"overview\":\"Forced to travel with her boyfriend to a horror festival, Laine begins to experience disturbing visions associated with the urban legend of The Creeper. As the festival arrives and the blood-soaked entertainment builds to a frenzy, she becomes the center of it while something unearthly has been summoned.\",\"popularity\":1435.419,\"poster_path\":\"/qVVegwPsW6n9unBtLWq1rzOutka.jpg\",\"release_date\":\"2022-09-15\",\"title\":\"Jeepers Creepers: Reborn\",\"video\":false,\"vote_average\":5.8,\"vote_count\":468},{\"adult\":false,\"backdrop_path\":\"/iVtpnbPE91vmi3LmcOXycEblwPA.jpg\",\"genre_ids\":[10749,35],\"id\":833097,\"original_language\":\"en\",\"original_title\":\"Falling for Christmas\",\"overview\":\"A newly engaged and spoiled hotel heiress finds herself in the care of a handsome, blue-collar lodge owner and his precocious daughter after getting total amnesia in a skiing accident.\",\"popularity\":952.958,\"poster_path\":\"/6GkphwL9s6dZb3DoQS9OQ4LcPgY.jpg\",\"release_date\":\"2022-11-10\",\"title\":\"Falling for Christmas\",\"video\":false,\"vote_average\":6.7,\"vote_count\":208},{\"adult\":false,\"backdrop_path\":\"/aQOWnw3HydsCQZ10O0wvxFOaWc3.jpg\",\"genre_ids\":[36,28,18],\"id\":551271,\"original_language\":\"en\",\"original_title\":\"Medieval\",\"overview\":\"The story of 14th century Czech icon and warlord Jan Zizka who defeated armies of the Teutonic Order and the Holy Roman Empire.\",\"popularity\":1698.152,\"poster_path\":\"/4njdAkiBdC5LnFApeXSkFQ78GdT.jpg\",\"release_date\":\"2022-09-08\",\"title\":\"Medieval\",\"video\":false,\"vote_average\":7.2,\"vote_count\":135},{\"adult\":false,\"backdrop_path\":\"/2cQMVHBaP1wK0UBX5SGDahB3lp3.jpg\",\"genre_ids\":[9648,53,27],\"id\":807356,\"original_language\":\"en\",\"original_title\":\"Watcher\",\"overview\":\"As a serial killer stalks the city, Julia — a young actress who just moved to town with her husband — notices a mysterious stranger watching her from across the street.\",\"popularity\":936.911,\"poster_path\":\"/6Hg1l0alQNdCbFSVodRyR78A84w.jpg\",\"release_date\":\"2022-06-03\",\"title\":\"Watcher\",\"video\":false,\"vote_average\":6.3,\"vote_count\":293},{\"adult\":false,\"backdrop_path\":\"/AaV1YIdWKnjAIAOe8UUKBFm327v.jpg\",\"genre_ids\":[28,18],\"id\":361743,\"original_language\":\"en\",\"original_title\":\"Top Gun: Maverick\",\"overview\":\"After more than thirty years of service as one of the Navy’s top aviators, and dodging the advancement in rank that would ground him, Pete “Maverick” Mitchell finds himself training a detachment of TOP GUN graduates for a specialized mission the likes of which no living pilot has ever seen.\",\"popularity\":755.371,\"poster_path\":\"/62HCnUTziyWcpDaBO2i1DX17ljH.jpg\",\"release_date\":\"2022-05-24\",\"title\":\"Top Gun: Maverick\",\"video\":false,\"vote_average\":8.3,\"vote_count\":4766},{\"adult\":false,\"backdrop_path\":\"/2iGUavwv86Hubv3V5Iq4qEQXDfE.jpg\",\"genre_ids\":[18,53,27],\"id\":848058,\"original_language\":\"es\",\"original_title\":\"Cerdita\",\"overview\":\"A bullied overweight teenager sees a glimpse of hope when her tormentors are brutally abducted by a mesmerizing stranger.\",\"popularity\":633.124,\"poster_path\":\"/8EIQAvJjXdbNDMmBtHtgGqbc09V.jpg\",\"release_date\":\"2022-10-07\",\"title\":\"Piggy\",\"video\":false,\"vote_average\":6.7,\"vote_count\":203},{\"adult\":false,\"backdrop_path\":\"/Ach0puWzxuO2imh1yWEUK7CGsx.jpg\",\"genre_ids\":[16,12,28,14],\"id\":900667,\"original_language\":\"ja\",\"original_title\":\"ONE PIECE FILM RED\",\"overview\":\"Uta — the most beloved singer in the world. Her voice, which she sings with while concealing her true identity, has been described as “otherworldly.” She will appear in public for the first time at a live concert. As the venue fills with all kinds of Uta fans — excited pirates, the Navy watching closely, and the Straw Hats led by Luffy who simply came to enjoy her sonorous performance — the voice that the whole world has been waiting for is about to resound.\",\"popularity\":567.715,\"poster_path\":\"/m80kPdrmmtEh9wlLroCp0bwUGH0.jpg\",\"release_date\":\"2022-08-06\",\"title\":\"One Piece Film Red\",\"video\":false,\"vote_average\":7.4,\"vote_count\":180},{\"adult\":false,\"backdrop_path\":\"/79PcXPpbDWql74h8Y00mNwbYMbS.jpg\",\"genre_ids\":[80,35,36,9648,53],\"id\":664469,\"original_language\":\"en\",\"original_title\":\"Amsterdam\",\"overview\":\"In the 1930s, three friends—a doctor, a nurse, and an attorney—witness a murder, become suspects themselves and uncover one of the most outrageous plots in North American history.\",\"popularity\":444.824,\"poster_path\":\"/6sJcVzGCwrDCBMV0DU6eRzA2UxM.jpg\",\"release_date\":\"2022-09-27\",\"title\":\"Amsterdam\",\"video\":false,\"vote_average\":6.1,\"vote_count\":320},{\"adult\":false,\"backdrop_path\":\"/au4HUSWDRadIcl9CqySlw1kJMfo.jpg\",\"genre_ids\":[80,28,53],\"id\":829799,\"original_language\":\"en\",\"original_title\":\"Paradise City\",\"overview\":\"Renegade bounty hunter Ryan Swan must carve his way through the Hawaiian crime world to wreak vengeance on the kingpin who murdered his father.\",\"popularity\":647.178,\"poster_path\":\"/xdmmd437QdjcCls8yCQxrH5YYM4.jpg\",\"release_date\":\"2022-11-11\",\"title\":\"Paradise City\",\"video\":false,\"vote_average\":6.7,\"vote_count\":7},{\"adult\":false,\"backdrop_path\":\"/jBIMZ0AlUYuFNsKbd4L6FojWMoy.jpg\",\"genre_ids\":[16,35,10749],\"id\":820067,\"original_language\":\"ja\",\"original_title\":\"映画 五等分の花嫁\",\"overview\":\"When five lovely young girls who hate studying hire part-time tutor Futaro, he guides not only their education but also their hearts. Time spent has brought them all closer, with feelings growing within the girls and Futaro. As they finish their third year of high school and their last school festival approaches, they set their sights on what’s next. Is there a future with one of them and Futaro?\",\"popularity\":456.598,\"poster_path\":\"/sg7klpt1xwK1IJirBI9EHaqQwJ5.jpg\",\"release_date\":\"2022-05-20\",\"title\":\"The Quintessential Quintuplets Movie\",\"video\":false,\"vote_average\":9.1,\"vote_count\":98}],\"total_pages\":93,\"total_results\":1849}"