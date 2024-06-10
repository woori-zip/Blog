function formatDate(createdAt) {
    // createdAt 문자열을 Date 객체로 변환
    const createdAtDate = new Date(createdAt);
    const now = new Date();

    // 현재 시간과 createdAt 시간의 차이를 밀리초 단위로 계산
    const diffTime = Math.abs(now - createdAtDate);

    // 차이를 일 단위로 계산
    const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));

    // 시(hour)와 분(minute)을 두 자리 숫자로 포맷팅
    const hours = String(createdAtDate.getHours()).padStart(2, '0');
    const minutes = String(createdAtDate.getMinutes()).padStart(2, '0');

    // 날짜 차이가 1일인 경우 "시:분" 형식으로 반환
    if (diffDays === 1) {
        return `${hours}시 ${minutes}분`;
    }
    // 날짜 차이가 7일 이내인 경우 "n일 전" 형식으로 반환
    else if (diffDays <= 7) {
        return `${diffDays}일 전`;
    }
    // 날짜 차이가 7일 이상인 경우 "yyyy년 MM월 dd일 HH시 mm분" 형식으로 반환
    else {
        const year = createdAtDate.getFullYear();
        const month = String(createdAtDate.getMonth() + 1).padStart(2, '0');
        const day = String(createdAtDate.getDate()).padStart(2, '0');
        return `${year}년 ${month}월 ${day}일 ${hours}시 ${minutes}분`;
    }
}
