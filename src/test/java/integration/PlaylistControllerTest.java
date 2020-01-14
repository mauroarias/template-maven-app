package integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class PlaylistControllerTest {
    private final static int DEFAULT_TIMEOUT = 50;
    private final static String HOSTNAME = "integration-test";
    private final static int PORT = 8090;
    private final static boolean IS_SSL = false;
//    private final static ClientConfig CLIENT_CONFIG = ClientConfig.build(DEFAULT_TIMEOUT, HOSTNAME, PORT, IS_SSL);
    private final static String CHANNEL_ID = "001";
    private final static int PLAYLIST_SIZE = 2;

//    private final HttpRestClient client = new HttpRestClient(CLIENT_CONFIG, ObjectMapperFactory.build());
//
//    private PlaylistRequest playlistRequest;
//    private GetPlaylistRequest getPlaylistRequest;

    @BeforeEach
    void setup() {
//        playlistRequest = null;
//        getPlaylistRequest = null;
    }

    @Nested
    public class WithAnonymousProfile {

        @BeforeEach
        public void setup() {
        }

        @Nested
        public class WhenWeHaveChannelIdPlaylistSize {

//            @BeforeEach
//            void setup() {
//                iHaveChannelIdPlaylistSize();
//            }

            @Test
            public void iHaveNewPlaylist() {
//                final Playlist playlist = createPlaylist();
//                assertThat(playlist.getId()).isNotNull();
            }
        }

//        @Nested
//        public class WhenWeNotHaveChannelId {
//
//            @BeforeEach
//            public void setup() {
//                playlistRequest = PlaylistRequest.builder().playlistName(CHANNEL_ID).build();
//            }
//
//            @Test
//            void iHaveNotNewPlaylist() {
//                iHaveBadRequest(playlistRequest, Playlist.class);
//            }
//        }
//
//        @Nested
//        public class WhenWeNotHavePlaylistRequest {
//
//            private final integration.PlaylistRequestNull playlistRequestNull = new integration.PlaylistRequestNull();
//
//            @BeforeEach
//            public void setup() {
//            }
//
//            @Test
//            void iHaveNotNewPlaylist() {
//                iHaveBadRequest(playlistRequestNull, Playlist.class);
//            }
//        }
//
//        @Nested
//        public class WhenWeRequestPlaylist {
//
//            private Playlist playlist = null;
//
//            @BeforeEach
//            public void setup() {
//                iHaveChannelIdPlaylistSize();
//                playlist = createPlaylist();
//                getPlaylistRequest = GetPlaylistRequest
//                    .builder()
//                    .playlistId(playlist.getId())
//                    .size(PLAYLIST_SIZE)
//                    .build();
//            }
//
//            @Test
//            public void iHavePlaylist() {
//                final Playlist moreItems = client.sendRequest(getPlaylistRequest, Playlist.class);
//                assertThat(moreItems.getId()).isNotNull();
//                assertThat(moreItems.getSongs()).hasSize(PLAYLIST_SIZE);
//                assertThat(moreItems.getId()).isEqualTo(playlist.getId());
//                assertThat(extractSongIds(moreItems.getSongs()))
//                    .isNotIn(extractSongIds(playlist.getSongs()));
//            }
//        }
//
//        @Nested
//        public class WhenRequestedPlaylistDoesNotExist {
//
//            @BeforeEach
//            public void setup() {
//                getPlaylistRequest = GetPlaylistRequest
//                    .builder()
//                    .playlistId(UUID.randomUUID())
//                    .size(PLAYLIST_SIZE)
//                    .build();
//            }
//
//            @Test
//            void iHaveMoreItems() {
//                iHaveBadRequest(getPlaylistRequest, Playlist.class);
//            }
//        }
//    }
//
//    @Nested
//    public class WithProfile {
//
//        @BeforeEach
//        public void setup() {
//        }
//
//        @Nested
//        public class WhenWeHaveExistingPlaylist {
//
//            @BeforeEach
//            void setup() {
//                iHaveChannelIdPlaylistSize();
//            }
//
//            @Test
//            public void iHaveNewPlaylist() {
//                final Playlist playlist = createPlaylist();
//                assertThat(playlist.getId()).isNotNull();
//                assertThat(playlist.getSongs()).hasSize(PLAYLIST_SIZE);
//                final Playlist newPlaylist = createPlaylist();
//                assertThat(playlist.getId()).isEqualTo(newPlaylist.getId());
//                assertThat(playlist.getSongs()).isNotIn(newPlaylist.getSongs());
//            }
//        }
//
//        @Nested
//        public class WhenWeHaveNotExistingPlaylist {
//
//            @BeforeEach
//            void setup() {
//                iHaveChannelIdPlaylistSize();
//            }
//
//            @Test
//            public void iHaveNewPlaylist() {
//                final Playlist playlist = createPlaylist();
//                assertThat(playlist.getId()).isNotNull();
//                assertThat(playlist.getSongs()).hasSize(PLAYLIST_SIZE);
//                final UUID newProfileId = UUID.randomUUID();
//                final Playlist newPlaylist = createPlaylist();
//                assertThat(playlist.getSongs()).doesNotContainAnyElementsOf(newPlaylist.getSongs());
//            }
//        }
//
//        @Nested
//        public class WhenWeRequestPlaylist {
//
//            private Playlist playlist = null;
//
//            @BeforeEach
//            public void setup() {
//                iHaveChannelIdPlaylistSize();
//                playlist = createPlaylist();
//                getPlaylistRequest = GetPlaylistRequest
//                        .builder()
//                        .playlistId(playlist.getId())
//                        .size(PLAYLIST_SIZE)
//                        .build();
//                final UUID newProfileId = UUID.randomUUID();
//            }
//
//            @Test
//            public void iHavePlaylist() {
//                final Playlist moreItems = client.sendRequest(getPlaylistRequest, Playlist.class);
//                assertThat(moreItems.getId()).isNotNull();
//                assertThat(moreItems.getSongs()).hasSize(PLAYLIST_SIZE);
//                assertThat(moreItems.getId()).isEqualTo(playlist.getId());
//                assertThat(extractSongIds(moreItems.getSongs()))
//                        .isNotIn(extractSongIds(playlist.getSongs()));
//            }
//        }
//
//        @Nested
//        public class WhenRequestedPlaylistDoesNotExist {
//
//            @BeforeEach
//            public void setup() {
//                getPlaylistRequest = GetPlaylistRequest
//                        .builder()
//                        .playlistId(UUID.randomUUID())
//                        .size(PLAYLIST_SIZE)
//                        .build();
//            }
//
//            @Test
//            void iHaveMoreItems() {
//                iHaveBadRequest(getPlaylistRequest, Playlist.class);
//            }
//        }
//    }
//
//    public void iHaveChannelIdPlaylistSize() {
//        playlistRequest = PlaylistRequest.builder().playlistName(CHANNEL_ID).build();
//    }
//
//    public void iHaveBadRequest(final HttpRequest httpRequest, final Class<?> clazz) {
//        assertThatThrownBy(() -> client.sendRequest(httpRequest, clazz));
//    }
//
//    private Playlist createPlaylist() {
//        return client.sendRequest(playlistRequest, Playlist.class);
//    }
//
//    private Set<String> extractSongIds(final List<Song> songs) {
//        return songs.stream().map(Song::getId).collect(Collectors.toSet());
    }
}
