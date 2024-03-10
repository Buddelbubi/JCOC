package de.buddelbubi;

import de.buddelbubi.player.Player;

public class Test {

    public static void main(String[] args) {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjNlNTg4MzMyLTdmNTctNDRlZC04YjMxLTVjYmZmNzY2M2UyYiIsImlhdCI6MTcxMDA3OTQ2OCwic3ViIjoiZGV2ZWxvcGVyLzIxZjJlZTBjLTRkM2ItMDljMy1kZjM0LTgwMGUyNWIzZTEyZSIsInNjb3BlcyI6WyJjbGFzaCJdLCJsaW1pdHMiOlt7InRpZXIiOiJkZXZlbG9wZXIvc2lsdmVyIiwidHlwZSI6InRocm90dGxpbmcifSx7ImNpZHJzIjpbIjMxLjE2LjExMS4xNzgiXSwidHlwZSI6ImNsaWVudCJ9XX0.Z09lbCLEOFKW5bfR8KNTgs7_HpTC2_-WRkwtvAxMfuQsw0r3vb0bfI01xajjw6dPY3YnZLyY3VEViKYyU8hUYQ";
        JCOC.login(token);

        Player player = new Player("#VVRQPYQC");
        System.out.println(player.getClanStripped().get().getType());

    }

}
