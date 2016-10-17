# Project 1 - *Flicks*

**Flicks** shows the latest movies currently playing in theaters. The app utilizes the Movie Database API to display images and basic information about these movies to the user.

Time spent: **32** hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **scroll through current movies** from the Movie Database API
* [x] Layout is optimized with the [ViewHolder](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView#improving-performance-with-the-viewholder-pattern) pattern. NOTE: I actually uesed a RecyclerView after speaking to Nathan about it. I did look through the ViewHolder pattern information from the link, and I realize now why we were asked to use this before moving on to RecyclerView so we understand better what is happening with RecyclerView.
* [x] For each movie displayed, user can see the following details:
  * [x] Title, Poster Image, Overview (Portrait mode)
  * [x] Title, Backdrop Image, Overview (Landscape mode)

The following **optional** features are implemented:

* [ ] User can **pull-to-refresh** popular stream to get the latest movies.
* [x] Display a nice default [placeholder graphic](http://guides.codepath.com/android/Displaying-Images-with-the-Picasso-Library#configuring-picasso) for each image during loading.
* [x] Improved the user interface through styling and coloring.

The following **bonus** features are implemented:

* [x] Allow user to view details of the movie including ratings and popularity within a separate activity or dialog fragment.
* [ ] When viewing a popular movie (i.e. a movie voted for more than 5 stars) the video should show the full backdrop image as the layout.  Uses [Heterogenous ListViews](http://guides.codepath.com/android/Implementing-a-Heterogenous-ListView) or [Heterogenous RecyclerView](http://guides.codepath.com/android/Heterogenous-Layouts-inside-RecyclerView) to show different layouts.
* [ ] Allow video trailers to be played in full-screen using the YouTubePlayerView.
    * [ ] Overlay a play icon for videos that can be played.
    * [ ] More popular movies should start a separate activity that plays the video immediately.
    * [ ] Less popular videos rely on the detail page should show ratings and a YouTube preview.
* [ ] Apply the popular [Butterknife annotation library](http://guides.codepath.com/android/Reducing-View-Boilerplate-with-Butterknife) to reduce boilerplate code.
* [x] Apply rounded corners for the poster or background images using [Picasso transformations](https://guides.codepath.com/android/Displaying-Images-with-the-Picasso-Library#other-transformations)
* [x] Replaced android-async-http network client with the popular [OkHttp](http://guides.codepath.com/android/Using-OkHttp) or [Volley](http://guides.codepath.com/android/Networking-with-the-Volley-Library) networking libraries.

## Video Walkthrough

Here's a walkthrough of implemented user stories:

### _Scrolling through movie stream in portrait and landscape:_

![screenshot](http://i.imgur.com/AzangF7.gif)

### _View details of a movie:_

![screenshot](http://i.imgur.com/ICnKPLp.gif)

GIFs created with [AZ Screen Recorder](https://play.google.com/store/apps/details?id=com.hecorat.screenrecorder.free&hl=en).

## Notes

Biggest challenge was that my daughter got the stomach flu and was puking all night Tuesday night, and we then had to spend many hours at the urgent care yesterday since she hasn't been eating or drinking much... Next biggest challenge was that the developer lead on my team at work quit with less than a week notice, so I had to work long hours during the week... but enough about life throwing curve bowling balls at ya :) (and fyi, my daughter is doing better now!)

I think the biggest challenge with the app that I encountered was that I started out being a bit too ambitious and tried out using the Android DataBinding library instead of uisng Butterknife. I was able to get it to work, but I wasn't able to get it to work with a RecyclerView and Adapter. So I scratched that and now wish I had just gone for Butterknife. I'll use it on the next assignment.

Other issue I ran into was I first started out with Glide instead of Picasso. But when using the placeholder with Glide, I ran into some wonkiness with the movie poster images being resized into the boundaries of the placeholder image. I never had this issue when using Picasso, so I went back to using Picasso for this assignment.

## Open-source libraries used

- [OkHTTP](http://square.github.io/okhttp/) - An HTTP & HTTP/2 client for Android and Java applications
- [Picasso](http://square.github.io/picasso/) - Image loading and caching library for Android
- [Picasso Transformations](https://github.com/wasabeef/picasso-transformations)- An Android transformation library providing a variety of image transformations for Picasso
- [GSON] (https://github.com/google/gson) - A Java serialization/deserialization library that can convert Java Objects into JSON and back.

## License

    Copyright [2016] [Javier Arboleda]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
