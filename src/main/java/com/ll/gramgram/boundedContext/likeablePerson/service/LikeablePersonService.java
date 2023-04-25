package com.ll.gramgram.boundedContext.likeablePerson.service;

import com.ll.gramgram.base.appConfig.AppConfig;
<<<<<<< HEAD
import com.ll.gramgram.base.event.EventAfterLike;
import com.ll.gramgram.base.event.EventAfterModifyAttractiveType;
import com.ll.gramgram.base.event.EventBeforeCancelLike;
=======
>>>>>>> d35a9ff3bbc13b200aa43b6c4cca9c289cda3493
import com.ll.gramgram.base.rsData.RsData;
import com.ll.gramgram.boundedContext.instaMember.entity.InstaMember;
import com.ll.gramgram.boundedContext.instaMember.service.InstaMemberService;
import com.ll.gramgram.boundedContext.likeablePerson.entity.LikeablePerson;
import com.ll.gramgram.boundedContext.likeablePerson.repository.LikeablePersonRepository;
import com.ll.gramgram.boundedContext.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
<<<<<<< HEAD
import java.util.Objects;
=======
>>>>>>> d35a9ff3bbc13b200aa43b6c4cca9c289cda3493
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LikeablePersonService {
    private final LikeablePersonRepository likeablePersonRepository;
    private final InstaMemberService instaMemberService;
<<<<<<< HEAD
    private final ApplicationEventPublisher publisher;

    @Transactional
    public RsData<LikeablePerson> like(Member actor, String username, int attractiveTypeCode) {
        RsData canLikeRsData = canLike(actor, username, attractiveTypeCode);
=======
    InstaMember fromInstaMember = null;
    InstaMember toInstaMember = null;

    @Transactional
    public RsData<LikeablePerson> like(Member member, String username, int attractiveTypeCode) {

        if (member.hasConnectedInstaMember() == false) {
            return RsData.of("F-2", "먼저 본인의 인스타그램 아이디를 입력해야 합니다.");
        }
>>>>>>> d35a9ff3bbc13b200aa43b6c4cca9c289cda3493

        if (canLikeRsData.isFail()) return canLikeRsData;

<<<<<<< HEAD
        if (canLikeRsData.getResultCode().equals("S-2")) return modifyAttractive(actor, username, attractiveTypeCode);

        InstaMember fromInstaMember = actor.getInstaMember();
        InstaMember toInstaMember = instaMemberService.findByUsernameOrCreate(username).getData();
=======
        fromInstaMember = member.getInstaMember();
        toInstaMember = instaMemberService.findByUsernameOrCreate(username).getData();
>>>>>>> d35a9ff3bbc13b200aa43b6c4cca9c289cda3493

        LikeablePerson likeablePerson = LikeablePerson
                .builder()
                .fromInstaMember(fromInstaMember) // 호감을 표시하는 사람의 인스타 멤버
<<<<<<< HEAD
                .fromInstaMemberUsername(actor.getInstaMember().getUsername()) // 중요하지 않음
=======
                .fromInstaMemberUsername(member.getInstaMember().getUsername()) // 중요하지 않음
>>>>>>> d35a9ff3bbc13b200aa43b6c4cca9c289cda3493
                .toInstaMember(toInstaMember) // 호감을 받는 사람의 인스타 멤버
                .toInstaMemberUsername(toInstaMember.getUsername()) // 중요하지 않음
                .attractiveTypeCode(attractiveTypeCode) // 1=외모, 2=능력, 3=성격
                .build();

        likeablePersonRepository.save(likeablePerson); // 저장

        // 너가 좋아하는 호감표시 생겼어.
        fromInstaMember.addFromLikeablePerson(likeablePerson);

        // 너를 좋아하는 호감표시 생겼어.
        toInstaMember.addToLikeablePerson(likeablePerson);

<<<<<<< HEAD
        publisher.publishEvent(new EventAfterLike(this, likeablePerson));

=======
>>>>>>> d35a9ff3bbc13b200aa43b6c4cca9c289cda3493
        return RsData.of("S-1", "입력하신 인스타유저(%s)를 호감상대로 등록되었습니다.".formatted(username), likeablePerson);


    }

    public List<LikeablePerson> findByFromInstaMemberId(Long fromInstaMemberId) {
        return likeablePersonRepository.findByFromInstaMemberId(fromInstaMemberId);
    }

<<<<<<< HEAD
=======

>>>>>>> d35a9ff3bbc13b200aa43b6c4cca9c289cda3493
    public Optional<LikeablePerson> findById(Long id) {
        return likeablePersonRepository.findById(id);
    }

    @Transactional
<<<<<<< HEAD
    public RsData cancel(LikeablePerson likeablePerson) {
        publisher.publishEvent(new EventBeforeCancelLike(this, likeablePerson));

        // 너가 생성한 좋아요가 사라졌어.
        likeablePerson.getFromInstaMember().removeFromLikeablePerson(likeablePerson);

        // 너가 받은 좋아요가 사라졌어.
        likeablePerson.getToInstaMember().removeToLikeablePerson(likeablePerson);

=======
    public RsData delete(LikeablePerson likeablePerson) {
>>>>>>> d35a9ff3bbc13b200aa43b6c4cca9c289cda3493
        likeablePersonRepository.delete(likeablePerson);

        String likeCanceledUsername = likeablePerson.getToInstaMember().getUsername();
        return RsData.of("S-1", "%s님에 대한 호감을 취소하였습니다.".formatted(likeCanceledUsername));
    }

<<<<<<< HEAD
    public RsData canCancel(Member actor, LikeablePerson likeablePerson) {
=======
    public RsData canActorDelete(Member actor, LikeablePerson likeablePerson) {
>>>>>>> d35a9ff3bbc13b200aa43b6c4cca9c289cda3493
        if (likeablePerson == null) return RsData.of("F-1", "이미 삭제되었습니다.");

        // 수행자의 인스타계정 번호
        long actorInstaMemberId = actor.getInstaMember().getId();
        // 삭제 대상의 작성자(호감표시한 사람)의 인스타계정 번호
        long fromInstaMemberId = likeablePerson.getFromInstaMember().getId();

        if (actorInstaMemberId != fromInstaMemberId)
            return RsData.of("F-2", "권한이 없습니다.");

        return RsData.of("S-1", "삭제가능합니다.");
    }

<<<<<<< HEAD
    private RsData canLike(Member actor, String username, int attractiveTypeCode) {
        if (!actor.hasConnectedInstaMember()) {
            return RsData.of("F-1", "먼저 본인의 인스타그램 아이디를 입력해주세요.");
        }

        InstaMember fromInstaMember = actor.getInstaMember();

        if (fromInstaMember.getUsername().equals(username)) {
            return RsData.of("F-2", "본인을 호감상대로 등록할 수 없습니다.");
        }

        // 액터가 생성한 `좋아요` 들 가져오기
        List<LikeablePerson> fromLikeablePeople = fromInstaMember.getFromLikeablePeople();

        // 그 중에서 좋아하는 상대가 username 인 녀석이 혹시 있는지 체크
        LikeablePerson fromLikeablePerson = fromLikeablePeople
                .stream()
                .filter(e -> e.getToInstaMember().getUsername().equals(username))
                .findFirst()
                .orElse(null);

        if (fromLikeablePerson != null && fromLikeablePerson.getAttractiveTypeCode() == attractiveTypeCode) {
            return RsData.of("F-3", "이미 %s님에 대해서 호감표시를 했습니다.".formatted(username));
        }

        long likeablePersonFromMax = AppConfig.getLikeablePersonFromMax();

        if (fromLikeablePerson != null) {
            return RsData.of("S-2", "%s님에 대해서 호감표시가 가능합니다.".formatted(username));
        }

        if (fromLikeablePeople.size() >= likeablePersonFromMax) {
            return RsData.of("F-4", "최대 %d명에 대해서만 호감표시가 가능합니다.".formatted(likeablePersonFromMax));
        }

        return RsData.of("S-1", "%s님에 대해서 호감표시가 가능합니다.".formatted(username));
    }

    private RsData<LikeablePerson> modifyAttractive(Member member, String username, int attractiveTypeCode) {
        // 액터가 생성한 `좋아요` 들 가져오기
        List<LikeablePerson> fromLikeablePeople = member.getInstaMember().getFromLikeablePeople();

        LikeablePerson fromLikeablePerson = fromLikeablePeople
                .stream()
                .filter(e -> e.getToInstaMember().getUsername().equals(username))
                .findFirst()
                .orElse(null);

        if (fromLikeablePerson == null) {
            return RsData.of("F-7", "호감표시를 하지 않았습니다.");
        }

        String oldAttractiveTypeDisplayName = fromLikeablePerson.getAttractiveTypeDisplayName();

        modifyAttractionTypeCode(fromLikeablePerson, attractiveTypeCode);

        String newAttractiveTypeDisplayName = fromLikeablePerson.getAttractiveTypeDisplayName();

        return RsData.of("S-3", "%s님에 대한 호감사유를 %s에서 %s(으)로 변경합니다.".formatted(username, oldAttractiveTypeDisplayName, newAttractiveTypeDisplayName), fromLikeablePerson);
    }

    public Optional<LikeablePerson> findByFromInstaMember_usernameAndToInstaMember_username(String fromInstaMemberUsername, String toInstaMemberUsername) {
        return likeablePersonRepository.findByFromInstaMember_usernameAndToInstaMember_username(fromInstaMemberUsername, toInstaMemberUsername);
    }

    @Transactional
    public RsData<LikeablePerson> modifyLike(Member actor, Long id, int attractiveTypeCode) {
        LikeablePerson likeablePerson = findById(id).orElseThrow();
        RsData canModifyRsData = canModifyLike(actor, likeablePerson);

        if (canModifyRsData.isFail()) {
            return canModifyRsData;
        }

        modifyAttractionTypeCode(likeablePerson, attractiveTypeCode);

        return RsData.of("S-1", "호감사유를 수정하였습니다.");
    }

    private void modifyAttractionTypeCode(LikeablePerson likeablePerson, int attractiveTypeCode) {
        int oldAttractiveTypeCode = likeablePerson.getAttractiveTypeCode();
        RsData rsData = likeablePerson.updateAttractionTypeCode(attractiveTypeCode);

        if (rsData.isSuccess()) {
            publisher.publishEvent(new EventAfterModifyAttractiveType(this, likeablePerson, oldAttractiveTypeCode, attractiveTypeCode));
        }
    }

    public RsData canModifyLike(Member actor, LikeablePerson likeablePerson) {
        if (!actor.hasConnectedInstaMember()) {
            return RsData.of("F-1", "먼저 본인의 인스타그램 아이디를 입력해주세요.");
        }

        InstaMember fromInstaMember = actor.getInstaMember();

        if (!Objects.equals(likeablePerson.getFromInstaMember().getId(), fromInstaMember.getId())) {
            return RsData.of("F-2", "해당 호감표시를 취소할 권한이 없습니다.");
        }


        return RsData.of("S-1", "호감표시취소가 가능합니다.");
    }
=======
    public RsData<LikeablePerson> canActorAdd(Member member, String username, int attractiveTypeCode) {

        long likeablePersonFromMax = AppConfig.getLikeablePersonFromMax();
        if(likeablePersonFromMax ==11){return RsData.of("F-2", "호감표시는 10개를 초과할 수 없습니다.");}

        InstaMember frominstaMember = member.getInstaMember();


        LikeablePerson likeablePerson = frominstaMember
                .getFromLikeablePeople()
                .stream()
                .filter(lp -> lp.getToInstaMember().getUsername().equals(username))
                .findFirst()
                .orElse(null);

        if (likeablePerson != null) {
            if(likeablePerson.getAttractiveTypeCode() != attractiveTypeCode){
                likeablePerson.setAttractiveTypeCode(attractiveTypeCode);
            return RsData.of("S-2","호감표시를 수정했습니다.");
            }
            return RsData.of("F-1", "이미 호감표시를 했습니다.기존 호감사유는 %s입니다.".formatted(likeablePerson.getAttractiveTypeDisplayName()));
        }
            return RsData.of("S-1", "호감 표시가 가능합니다.");
        }
>>>>>>> d35a9ff3bbc13b200aa43b6c4cca9c289cda3493
}

