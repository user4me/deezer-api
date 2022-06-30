package api.deezer.requests;

import api.deezer.converters.Converter;
import api.deezer.converters.ListConverter;
import api.deezer.http.impl.*;
import api.deezer.objects.GetPermissionsResponse;
import api.deezer.objects.Options;
import api.deezer.objects.SendNotificationResponse;
import api.deezer.objects.User;
import api.deezer.objects.data.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

// TODO: 01.11.2021 user / charts - what is the implementation?

/**
 * Requests related to user.
 */
public class UserRequests extends DeezerRequests {
    /**
     * Converts list of integers to comma separated values.
     */
    private final Converter<List<Integer>, String> listConverter = new ListConverter<Integer>();

    public UserRequests(String accessToken) {
        super(accessToken);
    }

    /**
     * Gets user by ID.
     *
     * @param userId user ID.
     * @return user.
     */
    public DeezerRequest<User> getById(long userId) {
        return new DeezerGetRequest<>(
                property("user.get", userId),
                User.class
        );
    }

    /**
     * Gets current user.
     *
     * @return current user.
     */
    public DeezerRequest<User> getMe() {
        return new DeezerGetRequest<>(
                property("user.get", "me"),
                accessTokenParam(),
                User.class
        );
    }

    /**
     * Gets user's favourite albums.
     *
     * @param userId user ID.
     * @return user's favourite albums.
     */
    public PaginationRequest<AlbumData> getFavouriteAlbums(long userId) {
        return new PaginationRequest<>(
                property("user.albums", userId),
                AlbumData.class
        );
    }

    /**
     * Gets user's favourite albums.
     *
     * @param userId user ID.
     * @return user's favourite albums.
     */
    public PaginationRequest<ArtistData> getFavouriteArtists(long userId) {
        return new PaginationRequest<>(
                property("user.artists", userId),
                ArtistData.class
        );
    }

    /**
     * Gets user's flow.
     *
     * @return user's flow.
     */
    public PaginationRequest<TrackData> getFlow() {
        return new PaginationRequest<>(
                property("user.flow", "me"),
                accessTokenParam(),
                TrackData.class
        );
    }

    /**
     * Gets user's followings.
     *
     * @param userId user ID.
     * @return user's followings.
     */
    public PaginationRequest<UserData> getFollowings(long userId) {
        return new PaginationRequest<>(
                property("user.followings", userId),
                UserData.class
        );
    }

    /**
     * Gets user's followers.
     *
     * @param userId user ID.
     * @return user's followers.
     */
    public PaginationRequest<UserData> getFollowers(long userId) {
        return new PaginationRequest<>(
                property("user.followers", userId),
                UserData.class
        );
    }

    /**
     * Gets current user's history.
     *
     * @return current user's history.
     */
    public PaginationRequest<TrackData> getMyHistory() {
        return new PaginationRequest<>(
                property("user.history", "me"),
                accessTokenParam(),
                TrackData.class
        );
    }

    // TODO: 03.11.2021 is it working?

    /**
     * Sends notification to user.
     *
     * @param message notification message.
     * @return request status.
     */
    public DeezerRequest<SendNotificationResponse> sendNotification(String message) {
        return new DeezerPostRequest<>(
                property("user.notifications"),
                accessTokenParam(),
                SendNotificationResponse.class
        );
    }

    /**
     * Gets user's permissions.
     *
     * @return user's permissions.
     */
    public DeezerRequest<GetPermissionsResponse> getPermissions() {
        return new DeezerGetRequest<>(
                property("user.permissions"),
                accessTokenParam(),
                GetPermissionsResponse.class
        );
    }

    /**
     * Gets user's options.
     *
     * @return user's options.
     */
    public DeezerRequest<Options> getOptions() {
        return new DeezerGetRequest<>(
                property("user.options"),
                accessTokenParam(),
                Options.class
        );
    }

    /**
     * Gets user's songs.
     *
     * @return user's songs.
     */
    public PaginationRequest<TrackData> getPersonalSongs() {
        return new PaginationRequest<>(
                property("user.personal"),
                accessTokenParam(),
                TrackData.class
        );
    }

    /**
     * Gets user's playlists.
     *
     * @param userId user ID.
     * @return user's playlists.
     */
    public PaginationRequest<PlaylistData> getPlaylists(long userId) {
        return new PaginationRequest<>(
                property("user.playlists", userId),
                PlaylistData.class
        );
    }

    /**
     * Gets user's favourite radios.
     *
     * @param userId user ID.
     * @return user's favourite radios.
     */
    public PaginationRequest<RadioData> getFavouriteRadios(long userId) {
        return new PaginationRequest<>(
                property("user.radios", userId),
                RadioData.class
        );
    }

    /**
     * Gets user's recommended albums.
     *
     * @return user's recommended albums.
     */
    public PaginationRequest<AlbumData> getRecommendedAlbums() {
        return new PaginationRequest<>(
                property("recommendations.albums"),
                accessTokenParam(),
                AlbumData.class
        );
    }

    /**
     * Gets user's recommended releases.
     *
     * @return user's recommended releases.
     */
    public PaginationRequest<AlbumData> getRecommendedReleases() {
        return new PaginationRequest<>(
                property("recommendations.releases"),
                accessTokenParam(),
                AlbumData.class
        );
    }

    /**
     * Gets user's recommended releases.
     *
     * @return user's recommended releases.
     */
    public PaginationRequest<ArtistData> getRecommendedArtists() {
        return new PaginationRequest<>(
                property("recommendations.artists"),
                accessTokenParam(),
                ArtistData.class
        );
    }

    /**
     * Gets user's recommended playlists.
     *
     * @return user's recommended playlists.
     */
    public PaginationRequest<PlaylistData> getRecommendedPlaylists() {
        return new PaginationRequest<>(
                property("recommendations.playlists"),
                accessTokenParam(),
                PlaylistData.class
        );
    }

    /**
     * Gets user's recommended tracks.
     *
     * @return user's recommended tracks.
     */
    public PaginationRequest<TrackData> getRecommendedTracks() {
        return new PaginationRequest<>(
                property("recommendations.tracks"),
                accessTokenParam(),
                TrackData.class
        );
    }

    /**
     * Gets user's recommended radios.
     *
     * @return user's recommended radios.
     */
    public PaginationRequest<RadioData> getRecommendedRadios() {
        return new PaginationRequest<>(
                property("recommendations.radios"),
                accessTokenParam(),
                RadioData.class
        );
    }

    /**
     * Gets user's favourite tracks.
     *
     * @param userId user ID.
     * @return user's favourite tracks.
     */
    public PaginationRequest<TrackData> getFavouriteTracks(long userId) {
        return new PaginationRequest<>(
                property("user.tracks", userId),
                TrackData.class
        );
    }

    /**
     * Adds album to user library.
     *
     * @param albumId album ID.
     * @return <i>true</i> if was successful.
     */
    public DeezerRequest<Boolean> addAlbumToLibrary(int albumId) {
        Map<String, String> params = accessTokenParam();
        params.put("album_id", String.valueOf(albumId));
        return new DeezerPostRequest<>(
                property("user.albums", "me"),
                params,
                Boolean.class
        );
    }

    /**
     * Adds artist to user favourites.
     *
     * @param artistId artist ID.
     * @return <i>true</i> if was successful.
     */
    public DeezerRequest<Boolean> addArtistToFavourites(int artistId) {
        Map<String, String> params = accessTokenParam();
        params.put("artist_id", String.valueOf(artistId));
        return new DeezerPostRequest<>(
                property("user.artists", "me"),
                params,
                Boolean.class
        );
    }

    /**
     * Follows a user.
     *
     * @param userId user ID to follow.
     * @return <i>true</i> if was successful.
     */
    public DeezerRequest<Boolean> follow(int userId) {
        Map<String, String> params = accessTokenParam();
        params.put("user_id", String.valueOf(userId));
        return new DeezerPostRequest<>(
                property("user.followings", "me"),
                params,
                Boolean.class
        );
    }

    /**
     * Creates a playlist.
     *
     * @param playlistTitle playlist title.
     * @return <i>true</i> if was successful.
     */
    public DeezerRequest<Boolean> createPlaylist(String playlistTitle) {
        Map<String, String> params = accessTokenParam();
        params.put("title", String.valueOf(playlistTitle));
        return new DeezerPostRequest<>(
                property("user.playlists", "me"),
                params,
                Boolean.class
        );
    }

    /**
     * Adds playlist to user favourites.
     *
     * @param playlistId playlist ID.
     * @return <i>true</i> if was successful.
     */
    public DeezerRequest<Boolean> addPlaylistToFavourites(long playlistId) {
        Map<String, String> params = accessTokenParam();
        params.put("playlist_id", String.valueOf(playlistId));
        return new DeezerPostRequest<>(
                property("user.playlists", "me"),
                params,
                Boolean.class
        );
    }

    /**
     * Adds podcast to user favourites.
     *
     * @param podcastId podcast ID.
     * @return <i>true</i> if was successful.
     */
    public DeezerRequest<Boolean> addPodcastToFavourites(int podcastId) {
        Map<String, String> params = accessTokenParam();
        params.put("podcast_id", String.valueOf(podcastId));
        return new DeezerPostRequest<>(
                property("user.podcasts", "me"),
                params,
                Boolean.class
        );
    }

    /**
     * Adds radio to user favourites.
     *
     * @param radioId radio ID.
     * @return <i>true</i> if was successful.
     */
    public DeezerRequest<Boolean> addRadioToFavourites(int radioId) {
        Map<String, String> params = accessTokenParam();
        params.put("radio_id", String.valueOf(radioId));
        return new DeezerPostRequest<>(
                property("user.radios", "me"),
                params,
                Boolean.class
        );
    }

    /**
     * Adds tracks to user favourites.
     *
     * @param trackIds tracks IDs.
     * @return <i>true</i> if was successful.
     */
    public DeezerRequest<Boolean> addTracksToFavourites(Integer... trackIds) {
        return addTracksToFavourites(Arrays.asList(trackIds));
    }

    /**
     * Adds tracks to user favourites.
     *
     * @param trackIds tracks IDs.
     * @return <i>true</i> if was successful.
     */
    public DeezerRequest<Boolean> addTracksToFavourites(List<Integer> trackIds) { // TODO: 21.11.2021 check if it's working
        Map<String, String> params = accessTokenParam();
        params.put("songs", String.valueOf(listConverter.convert(trackIds)));
        return new DeezerPostRequest<>(
                property("user.tracks", "me"),
                params,
                Boolean.class
        );
    }

    /**
     * Removes an album from the user's library.
     *
     * @param albumId album ID.
     * @return <i>true</i> if was successful.
     */
    public DeezerRequest<Boolean> removeAlbum(int albumId) {
        Map<String, String> params = accessTokenParam();
        params.put("album_id", String.valueOf(albumId));
        return new DeezerDeleteRequest<>(
                property("user.albums", "me"),
                params,
                Boolean.class
        );
    }

    /**
     * Removes an artist from the user's favorites.
     *
     * @param artistId artist ID.
     * @return <i>true</i> if was successful.
     */
    public DeezerRequest<Boolean> removeArtist(int artistId) {
        Map<String, String> params = accessTokenParam();
        params.put("artist_id", String.valueOf(artistId));
        return new DeezerDeleteRequest<>(
                property("user.artists", "me"),
                params,
                Boolean.class
        );
    }

    /**
     * Unfollows user.
     *
     * @param followingId following ID.
     * @return <i>true</i> if was successful.
     */
    public DeezerRequest<Boolean> unfollow(long followingId) {
        Map<String, String> params = accessTokenParam();
        params.put("user_id", String.valueOf(followingId));
        return new DeezerDeleteRequest<>(
                property("user.followings", "me"),
                params,
                Boolean.class
        );
    }

    /**
     * Removes a playlist from the user's favorites.
     *
     * @param playlistId playlist ID.
     * @return <i>true</i> if was successful.
     */
    public DeezerRequest<Boolean> removePlaylist(long playlistId) {
        Map<String, String> params = accessTokenParam();
        params.put("playlist_id", String.valueOf(playlistId));
        return new DeezerDeleteRequest<>(
                property("user.playlists", "me"),
                params,
                Boolean.class
        );
    }

    /**
     * Removes a podcast from the user's favorites.
     *
     * @param podcastId podcast ID.
     * @return <i>true</i> if was successful.
     */
    public DeezerRequest<Boolean> removePodcast(int podcastId) {
        Map<String, String> params = accessTokenParam();
        params.put("podcast_id", String.valueOf(podcastId));
        return new DeezerDeleteRequest<>(
                property("user.podcasts", "me"),
                params,
                Boolean.class
        );
    }

    /**
     * Removes a radio from the user's favorites.
     *
     * @param radio radio ID.
     * @return <i>true</i> if was successful.
     */
    public DeezerRequest<Boolean> removeRadio(int radio) {
        Map<String, String> params = accessTokenParam();
        params.put("radio_id", String.valueOf(radio));
        return new DeezerDeleteRequest<>(
                property("user.radios", "me"),
                params,
                Boolean.class
        );
    }

    /**
     * Removes a track from the user's favorites.
     *
     * @param trackId track ID.
     * @return <i>true</i> if was successful.
     */
    public DeezerRequest<Boolean> removeTrack(int trackId) {
        Map<String, String> params = accessTokenParam();
        params.put("track_id", String.valueOf(trackId));
        return new DeezerDeleteRequest<>(
                property("user.tracks", "me"),
                params,
                Boolean.class
        );
    }

    /**
     * Creates <i>access_token</i> param.
     *
     * @return <i>access_token</i> param.
     */
    private Map<String, String> accessTokenParam() {
        return params(entry("access_token", getAccessToken()));
    }
}
