pub struct solution_struct {}

impl solution_struct {

    pub fn find_median_sorted_arrays(nums1: Vec<i32>, nums2: Vec<i32>) -> f64 {
        let (nums1_len, nums2_len) = (nums1.len(), nums2.len());

        let (mid, mid2) = ((nums1_len + nums2_len) >> 1, (nums1_len + nums2_len - 1) >> 1);

        let mut a = 0;
        let mut b: i32 = 0;

        let mut i = 0;
        let mut j = 0;

        for _ in 0..=mid {
            b = a;

            if i >= nums1_len || (j < nums2_len && nums2[j] < nums1[i]) {
                a = nums2[j];
                j += 1;
            } else {
                a = nums1[i];
                i += 1;
            }
        }

        return if mid == mid2 {
            a as f64
        } else {
            ((a + b) as f64) / 2.0
        };
    }
}

#[test]
pub(crate) fn main() {

    let input1 = vec![1, 6];
    let input2 = vec![1, 2, 5, 7, 8, 9];
    println!("{}", solution_struct::find_median_sorted_arrays(input1, input2));
}