use crate::leetcode::base::ListNode::ListNode;
use std::option::Option::Some;

pub fn add_two_numbers(l1: Option<Box<ListNode>>, l2: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
    let mut sum = 0;

    let mut _list = None;

    let mut p = &mut _list;

    let (mut l1, mut l2) = (l1, l2);

    loop {
        match (l1, l2) { // 每次都需呀初始化

            (Some(v1), Some(v2)) => {
                sum += v1.val + v2.val;
                l1 = v1.next;
                l2 = v2.next;
            }

            (Some(v1), None) => {
                sum += v1.val;
                l1 = v1.next;
                l2 = None;
            }

            (None, Some(v2)) => {
                sum += v2.val;
                l1 = None;
                l2 = v2.next;
            }

            _ => {
                break;
            }
        }

        *p = Some(Box::new(ListNode::new(sum % 10)));

        sum /= 10;

        if let Some(p_box_node) = p { p = &mut p_box_node.next }
    }

    if sum != 0 { *p = Some(Box::new(ListNode::new(sum))) }

    return _list;
}

#[test]
pub(crate) fn main() {}