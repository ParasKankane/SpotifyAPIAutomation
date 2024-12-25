Feature: Spotify Authorization


@Sanity
Scenario Outline: Validate Create Playist 
	Given create Playlist Payload with "<name>" and "<description>"
	When user call the "createPlaylist" api  
	Then api call got success with status code 201
	And name is equals to "<name>"
	And description is equals to "<description>"
	
	
	Examples: 
					| name     			 | description 																	|
					| Paras Playlist | This playlist is created for testing purpose | 