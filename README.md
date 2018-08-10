# Spatiotemporal Analysis using Hadoop MapReduce

The project analyzes the sample of the North American Mesoscale Forecast System (NAM) dataset collected by NOAA.

### 1. Three places most likely to be struck by lightning:

<img width="378" alt="9evx" src="https://user-images.githubusercontent.com/21329854/33336788-e4a555ec-d425-11e7-865f-b4dbc1db8667.PNG">

<img width="371" alt="9evf" src="https://user-images.githubusercontent.com/21329854/33336798-ee493f32-d425-11e7-815e-98543f27ba5d.PNG">

<img width="367" alt="9ev0" src="https://user-images.githubusercontent.com/21329854/33336808-f7fb04b6-d425-11e7-8651-8f55558f24e0.PNG">


### 2. Driest month in the bay area: (to determine the data points in the bay area, I have a condition in my mapper to get all the geohashes startingWith "9q" )

February

<img width="241" alt="drymonth" src="https://user-images.githubusercontent.com/21329854/33418297-14fb70c0-d55a-11e7-9093-7d59a7fb60a8.png">

### 3. Five travel locations and the best time to visit: (Geohashes for my favorite cities taken from geohash locator. The criteria to select the best time to visit is when relative_humidity_zerodegc_isotherm is greater than 0 and less than 60 percent)

<img width="370" alt="1" src="https://user-images.githubusercontent.com/21329854/33339275-7cb8bcbe-d42d-11e7-855c-adf19e060a4d.PNG">  [Sep, Feb, Mar, Apr, Oct, May, Nov, Dec, Jul, Jun, Aug]

<img width="371" alt="2" src="https://user-images.githubusercontent.com/21329854/33339337-a350751a-d42d-11e7-9eb7-edbe1ba78bb2.PNG">  [Sep, Feb, Mar, Apr, Oct, Jan, May, Nov, Dec, Jul, Jun, Aug]

<img width="371" alt="3" src="https://user-images.githubusercontent.com/21329854/33339372-bd80e19a-d42d-11e7-9f05-e320cc1400dc.PNG">  [Sep, Feb, Mar, Apr, Oct, Jan, May, Nov, Dec, Jul, Jun, Aug]

<img width="363" alt="4" src="https://user-images.githubusercontent.com/21329854/33339421-ebd7cf9a-d42d-11e7-9fc4-f7d46a63a3db.PNG">  [Sep, Feb, Mar, Apr, Oct, Jan, May, Nov, Dec, Jul, Jun, Aug]

<img width="376" alt="5" src="https://user-images.githubusercontent.com/21329854/33339449-0a3324d0-d42e-11e7-9ad2-bacd7c3012e1.PNG">  [Sep, Feb, Mar, Apr, Oct, Jan, May, Nov, Dec, Jul, Jun, Aug]

### 4. Solar And Wind Farms:

Solar Farm:

<img width="370" alt="s" src="https://user-images.githubusercontent.com/21329854/33418589-6e5ff0cc-d55b-11e7-8f1d-7395c7198631.PNG">

<img width="360" alt="s2" src="https://user-images.githubusercontent.com/21329854/33418592-749abb8e-d55b-11e7-8a2a-88bf4c681ed1.PNG">

<img width="350" alt="s3" src="https://user-images.githubusercontent.com/21329854/33418594-7b648148-d55b-11e7-82c3-274cafe4c93e.PNG">

Wind Farm:

<img width="372" alt="w1" src="https://user-images.githubusercontent.com/21329854/33418563-52fd34fc-d55b-11e7-9a73-82b67c8f1077.PNG">

<img width="339" alt="w2" src="https://user-images.githubusercontent.com/21329854/33418570-59eb2918-d55b-11e7-8840-035a0f215cb6.PNG">

<img width="314" alt="w3" src="https://user-images.githubusercontent.com/21329854/33418573-612286c2-d55b-11e7-82f1-693968e71523.PNG">

Solar and Wind Farm:

<img width="329" alt="sw1" src="https://user-images.githubusercontent.com/21329854/33418549-3a5294ce-d55b-11e7-96ff-9864fa612064.PNG">

<img width="400" alt="sw2" src="https://user-images.githubusercontent.com/21329854/33418556-4254af40-d55b-11e7-8510-dd3e472cc6b7.PNG">

<img width="336" alt="sw3" src="https://user-images.githubusercontent.com/21329854/33418559-4991d878-d55b-11e7-90b2-e5ac8ec835ae.PNG">


### 5. Climate Chart:

<img width="500" alt="climate" src="https://user-images.githubusercontent.com/21329854/33342928-7f94a21c-d438-11e7-8efb-292781521234.png">

