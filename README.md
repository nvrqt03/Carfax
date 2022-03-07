# Carfax

## Overview

#### This app takes data from a specified endpoint and creates a search results page. The results page shows the vehicle year, make, and model, as well as price, mileage, and location.

![Screenshot_20220307-100022](https://user-images.githubusercontent.com/22177989/157074994-093b06ae-fbc2-4638-8a9e-45c73fd995e9.png)


#### Clicking on a particular image will bring you to the car detail screen, where you can see additional information about the vehicle. 

![Screenshot_20220307-100042](https://user-images.githubusercontent.com/22177989/157075016-ce2ccdef-7744-4534-a2ca-cac080624cfa.png)


#### The call dealer button will populate the user's phone with the number for that particular dealer, where they can place a call.
![Screenshot_20220307-100032](https://user-images.githubusercontent.com/22177989/157075040-b48728af-c28e-4d17-9c5d-5a7c5814d67e.png)

## Technologies used
- Java
- Retrofit
- RoomDb
- MVVM


## Issues
- Initially was unaware that the search results were only for one vehicle
- ReactiveX framework - I struggled quite a bit here trying to implement this. Ultimately I decided to continue with Retrofit and the ExecutorService in order to complete the assignment and submit a working app. This will be something that I study moving forward.
- Offline - This was a struggle for me as well. I was able to use the data access object to insert into the RoomDb, however there ended up being multiple tables. Retrieving the data from the tables in a format I could use to update the adapter/Ui was something I had a tough time with. This will be another area I study, and something I will prioritize since offline capabilities may be a common use case.


## Final thoughts
This was a fun project! I enjoyed spending time working on this, and would have liked to continue to figure out how the offline portion especially. It's fun to see what tech stack a company is using and why. 
