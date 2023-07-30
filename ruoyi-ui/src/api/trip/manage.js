import request from '@/utils/request'

export function insertTrip(data) {
  return request({
    url: '/trip/manage',
    method: 'post',
    data: data
  })
}

export function insertToursim(data) {
  return request({
    url: 'trip/manage/list',
    data: data,
    method: "post"
  })
}
